package restassured.cookiesandheaders;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Captureheaders {

//    Validating headers info in then part

    @Test
    void headersInfoValidation() {

        given()

                .when()
                .get("https://www.google.com")

                .then()
                .header("content-type", "text/html; charset=ISO-8859-1")
                .and()
                .header("cache-control", "private, max-age=0")
                .header("content-encoding", "gzip")
                .header("server", "gws")
                .log().all();

    }

//    Capturing headers info of single header

    @Test
    void getSingleCookieInfo() {

        Response rs = given()

                .when()
                .get("https://www.google.com");

        String headerinfo = rs.getHeader("accept-ch");
        System.out.println(headerinfo);

        System.out.println(rs.getHeader("content-encoding"));


    }

//    Capture all the headers info

    @Test
    void getAllHeadersInfo() {
        Response rs = given()

                .when()
                .get("https://www.google.com");

        Headers allheaders = rs.getHeaders();
        for (Header singleheader : allheaders) {
            System.out.println(singleheader.getName() + "  " + singleheader.getValue());

        }

    }


}
