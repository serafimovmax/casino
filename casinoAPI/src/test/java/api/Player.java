package api;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import java.util.Base64;

@Getter
@Setter
public class Player {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String encodedPasswordString;
    private String email;
    private String currencyCode;
    private Integer id;
    private Integer country_id;
    private Integer timezone_id;
    private String gender;
    private String phone_number;
    private String birthdate;
    private Boolean bonuses_allowed;
    private Boolean is_verified;

    public Player() {
        Faker faker = new Faker();
        name = faker.name().firstName();
        surname = faker.name().lastName();
        username = faker.regexify("[a-z]{6,8}");
        password = "vomifares13xa";
        encodedPasswordString = Base64.getEncoder().encodeToString(password.getBytes());
        email = username + "@maxi.com";
        currencyCode = "EUR";
    }
}
