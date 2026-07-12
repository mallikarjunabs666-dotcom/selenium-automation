package Day3APITesting;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class usinglogmethods {


    @Test
    void logusage()
    {

        given()

                .when()
                .get("https://www.google.com/")

                .then()
                .log().all() // print evrything from response including body, cookies, headers, statuscode
                .log().headers() // print only the headers

                .log().cookies() // print only cookies from the resposne
                .log().body() ;// print only body from the response









    }
}
