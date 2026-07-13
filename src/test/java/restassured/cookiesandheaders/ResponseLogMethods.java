package restassured.cookiesandheaders;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseLogMethods {

    @Test
    void differentLogMethods() {
        given()

                .when()
                .get("https://www.google.com")

                .then()
                .statusCode(200)
                .log().all()
                .log().body()
                .log().cookies()
                .log().headers();
    }


}
