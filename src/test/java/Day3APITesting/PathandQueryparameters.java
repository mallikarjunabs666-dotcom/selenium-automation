package Day3APITesting;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathandQueryparameters

{
    @Test
    void pathandqueryparam()
    {

        //url : https://reqres.in/api/users?page=2

        given()
                .pathParams("myusers", "Users")
                .queryParam("page", 2)

                .when()
                .post("https://reqres.in/api/{myusers}")


                .then()
                .log().all();

    }
}
