package Day3APITesting;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Cookies {

    @Test
    void cookie()
    {

        Response rs = given()

            .when()
            .get("https://www.google.com/");

//            .then()
//            .statusCode(200);
//            .cookie("AEC", "ANmZwa2mDkFeinLk1xwmssZaH4nku3KA5ydbxdZdqer-gfpGL3zjHQpjdV9B-ua4aA6w1HwEk6J18QwFK-k9uK00Tdmk1b8h4-HZ");
// we dont verify cookies in then method, since cookies values keeps changing

//        so we capture the response and from resposne we are printing cookies along with cookie key

//        To capture single cookie info
         String cookie1 = rs.getCookie("AEC");
            String cookie2 =     rs.getCookie("NID");

        System.out.println(cookie1);
        System.out.println(cookie2);

//        to print all the cookie with value
//        Ti capture all the cookie info

      Map<String, String> cookievalues =  rs.getCookies();

      for (String k : cookievalues.keySet())
      {
          System.out.println(rs.getCookie(k));

      }

    }

}
