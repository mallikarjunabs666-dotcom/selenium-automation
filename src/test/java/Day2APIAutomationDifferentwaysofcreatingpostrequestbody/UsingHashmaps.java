package Day2APIAutomationDifferentwaysofcreatingpostrequestbody;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class UsingHashmaps {

    int bookingiddd;

    String token;

    @Test(priority = 1)
    void datausinghasmap()
    {

        HashMap<String, Object> data = new HashMap<>();

        data.put("firstname", "Malli");
        data.put("lastname", "BS");
        data.put("totalprice", 1234);
        data.put("depositpaid", true);

        HashMap<String, String> bookingdates=new HashMap<>();

        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        data.put("bookingdates", bookingdates);
        data.put("additionalneeds", "Breakfast");


         given()
                .contentType("application/json")
                .body(data)


                .when()
                .post("https://restful-booker.herokuapp.com/booking")
//                .jsonPath().getInt("bookingid")

                 .then()
                 .statusCode(200)
                 .body("booking.firstname", equalTo("Malli"))
                 .body("booking.lastname", equalTo("BS"))
                 .body("booking.totalprice", equalTo(1234));







    }

    @Test(priority = 2)
    void createtoken()
    {

        HashMap<String, String> tokens=new HashMap<>();
        tokens.put("username", "admin");
        tokens.put("password", "password123");

        token= given()
                .contentType("application/json")
                .body(tokens)

                .when()
                .post("https://restful-booker.herokuapp.com/auth")
                .jsonPath().getString("token");



    }


    @Test(priority = 3, dependsOnMethods = {"datausinghasmap", "createtoken"})
    void deltebody()
    {

        given()
                .cookie("token", token)

                .when()
                .delete("https://restful-booker.herokuapp.com/booking/"+bookingiddd)


                .then()
                .statusCode(201)
                .log().all();


    }

}
