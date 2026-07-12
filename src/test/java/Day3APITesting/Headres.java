package Day3APITesting;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Headres {


    @Test
    void headersinfo()
    {

     Response rs =    given()

                .when()
                .get("https://www.google.com/");



//                .then()
//                .statusCode(200)
//
////                here we are just validating headers content is correct or not
//                .header("content-type", "text/html; charset=ISO-8859-1")
//                .header("content-encoding", "gzip")
//                .and()
////                If we have multiple validations we can use and method, but not necessary
//                .header("server", "gws");


// here we are capturing all the header information based on key

      String v1 =   rs.getHeader("content-type");
      String v2 = rs.getHeader("content-encoding");
      String v3 = rs.getHeader("server");

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

//        Capturing all the headers info

       Headers allheaders = rs.getHeaders();

       for (Header h : allheaders)
       {
           System.out.println(h.getName() + "   " + h.getValue());

       }




    }
}
