package api;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Feature("API Tests")
public class CasinoApiTests {

    private static String accessToken;
    private static String newUserAccessToken;
    private final static Player newPlayer = new Player();

    @Order(1)
    @Test
    @Story("GET Request")
    @Description("Get Access Token")
    public void postRequestToken() {

        Map<String, String> params = new HashMap<>();
        params.put("scope", "guest:default");

        Response response = RequestSpecifications.auth("client_credentials", params);

        response
            .then().log().body();
        accessToken = response.path("access_token");
        int statusCode = response.getStatusCode();

        assertThat(accessToken, is(notNullValue()));
        assertThat(accessToken, is(not(equalTo(""))));
        assertEquals(200, statusCode, "Code should be 200!");
    }

    @Order(2)
    @Test
    @Story("POST Request")
    @Description("Register new Player")
    public void registerNewPlayer() {

        Response registration = given().urlEncodingEnabled(true)
                                       .filter(new AllureRestAssured())
                                       .spec(RequestSpecifications.getRequestSpecificationBuilder().build())
                                       .header("Accept", ContentType.JSON.getAcceptHeader())
                                       .header("Authorization", "Bearer " + accessToken)
                                       .param("username", newPlayer.getUsername())
                                       .param("name", newPlayer.getName())
                                       .param("surname", newPlayer.getSurname())
                                       .param("password_change", newPlayer.getEncodedPasswordString())
                                       .param("password_repeat", newPlayer.getEncodedPasswordString())
                                       .param("email", newPlayer.getEmail())
                                       .param("currency_code", newPlayer.getCurrencyCode())
                                       .log().params()
                                       .when()
                                       .post(Constants.PLAYERS);

        registration
            .then()
            .log().body()
            .assertThat()
            .statusCode(201)
            .body("username", equalTo(newPlayer.getUsername()))
            .body("email", equalTo(newPlayer.getEmail()))
            .body("name", equalTo(newPlayer.getName()))
            .body("surname", equalTo(newPlayer.getSurname()))
            .body(matchesJsonSchemaInClasspath("jsonResponseSchemas/responseCreateNewUserJSONSchema.json"));

        newPlayer.setId(registration.path("id"));
        newPlayer.setCountry_id(registration.path("country_id"));
        newPlayer.setTimezone_id(registration.path("timezone_id"));
        newPlayer.setGender(registration.path("gender"));
        newPlayer.setPhone_number(registration.path("phone_number"));
        newPlayer.setBirthdate(registration.path("birthdate"));
        newPlayer.setBonuses_allowed(registration.path("bonuses_allowed"));
        newPlayer.setIs_verified(registration.path("is_verified"));
    }

    @Order(3)
    @Test
    @Story("GET Request")
    @Description("Authenticate new Player")
    public void authAsCreatedPlayer() {

        Map<String, String> params = new HashMap<>();
        params.put("username", newPlayer.getUsername());
        params.put("password", newPlayer.getEncodedPasswordString());

        Response response = RequestSpecifications.auth("password", params);

        response
            .then().log().body();

        int statusCode = response.getStatusCode();
        newUserAccessToken = response.path("access_token");

        assertEquals(200, statusCode, "Code should be 200!");
        assertThat(newUserAccessToken, is(notNullValue()));
        assertThat(newUserAccessToken, is(not(equalTo(""))));
    }

    @Order(4)
    @Test
    @Story("GET Request")
    @Description("Get player profile")
    public void getSelfPlayerProfile() {

        Response playerProfile = given().urlEncodingEnabled(true)
                                        .filter(new AllureRestAssured())
                                        .spec(RequestSpecifications.getRequestSpecificationBuilder().build())
                                        .header("Authorization", "Bearer " + newUserAccessToken)
                                        .pathParam("userId", newPlayer.getId())
                                        .log().all()
                                        .when()
                                        .get(Constants.PLAYERS + "/{userId}");

        playerProfile
            .then()
            .log().body()
            .assertThat()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("jsonResponseSchemas/responseGetUserJSONSchema.json"));
    }

    @Order(5)
    @Test
    @Story("GET Request")
    @Description("Get another player profile with wrong auth token")
    public void getOtherPlayerProfile() {

        Response otherProfile = given().urlEncodingEnabled(true)
                                       .filter(new AllureRestAssured())
                                       .spec(RequestSpecifications.getRequestSpecificationBuilder().build())
                                       .header("Authorization", "Bearer " + newUserAccessToken)
                                       .pathParam("userId", newPlayer.getId() - 1)
                                       .log().all()
                                       .when()
                                       .get(Constants.PLAYERS + "/{userId}");

        otherProfile
            .then()
            .log().body()
            .assertThat().statusCode(404);
    }
}
