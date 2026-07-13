package restassured.cookiesAndheaders;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CaptureCookiesInformation {

    @Test
    void singleCookieInfi() {
        Response rs = given()

                .when()
                .get("https://www.google.com");

        String cookieinfo = rs.getCookie("AEC");


        System.out.println("Value of the cookie is " + cookieinfo);
        System.out.println(rs.getCookie("NID"));
        System.out.println(rs.getCookie("__Secure-STRP"));
    }

    @Test
    void multipleCookieInformation() {
        Response rs = given()

                .when()
                .get("https://www.google.com");

        Map<String, String> cookiesinfo = rs.getCookies();

        System.out.println("cookies key " + cookiesinfo.keySet());

        for (String singlecookiekey : cookiesinfo.keySet()) {
            String cookievalue = rs.getCookie(singlecookiekey);
            System.out.println(singlecookiekey + " = " + cookievalue);

        }


    }

}
