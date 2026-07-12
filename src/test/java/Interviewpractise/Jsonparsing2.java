package Interviewpractise;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Jsonparsing2 {

    @Test
    void jsonparsing()
    {
       Response rs =  given()

                .when()
                .get("url here");

      String fn =  rs.jsonPath().get("booking.firstname").toString();
      String cd = rs.jsonPath().get("booking.bookingdates.checkin").toString();
      String ln = rs.jsonPath().getString("booking.lastname");
      int id = rs.jsonPath().getInt("bookingid");

    }
}
