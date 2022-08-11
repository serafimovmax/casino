package api;

import static io.restassured.RestAssured.given;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

public class RequestSpecifications {
    private static RequestSpecBuilder requestSpecBuilder;

    static RequestSpecBuilder getRequestSpecificationBuilder() {
        createRequestSpecification();
        return requestSpecBuilder;
    }

    private static void createRequestSpecification() {
        requestSpecBuilder = new RequestSpecBuilder()
            .setBaseUri(Constants.BASE_URI)
            .setBasePath(Constants.BASE_PATH)
            .addHeader("Accept", ContentType.JSON.getAcceptHeader());
    }

    static Response auth(String grantTypeValue, Map<String, ?> authParams) {
        createRequestSpecification();

        RequestSpecification authParamsSpecification = requestSpecBuilder
            .addParams(authParams)
            .build();
        return given().urlEncodingEnabled(true)
                      .filter(new AllureRestAssured())
                      .auth()
                      .preemptive()
                      .basic(Constants.BASIC_AUTH, "")
                      .param("grant_type", grantTypeValue)
                      .spec(authParamsSpecification)
                      .log()
                      .all()
                      .post(Constants.OAUTH2);
    }
}
