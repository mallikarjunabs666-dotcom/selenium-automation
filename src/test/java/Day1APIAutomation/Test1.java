package Day1APIAutomation;


import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class Test1 {

    String name;

    @Test(priority = 1)
    void Getusers() {

        given()

                .when()
                .get("https://restful-booker.herokuapp.com/booking")


                .then()
                .statusCode(200)
                .log().all();


    }

    @Test(priority = 2)
    void createBooking() {

        HashMap<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2026-10-10");
        bookingdates.put("checkout", "2026-11-11");

        HashMap<String, Object> data = new HashMap<>();

        data.put("firstname", "Malli");
        data.put("lastname", "BS");
        data.put("totalprice", 1234);
        data.put("depositpaid", true);
        data.put("bookingdates", bookingdates);
        data.put("additionalneeds", "lunch");


        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://restful-booker.herokuapp.com/booking")

                .then()
                .statusCode(200)
                .log().all();
    }
}


