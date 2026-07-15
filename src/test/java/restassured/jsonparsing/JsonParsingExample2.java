package restassured.jsonparsing;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JsonParsingExample2 {

    @Test
    void jsonParsing() {
        JSONObject data = new JSONObject();
        data.put("firstname", "Malli");
        data.put("lastname", "BS");
        data.put("totalprice", 111);
        data.put("depositpaid", true);

        JSONObject dates = new JSONObject();
        dates.put("checkin", "2018-01-01");
        dates.put("checkout", "2019-01-01");

        data.put("bookingdates", dates);
        data.put("additionalneeds", "Breakfast");

        Response response = given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://restful-booker.herokuapp.com/booking")

                .then()
                .statusCode(200)
//                .body("bookingid", equalTo(1))
                .body("booking.firstname", equalTo("Malli"))
                .body("booking.bookingdates.checkin", equalTo("2018-01-01"))
                .extract().response();

        System.out.println("First name is " + response.jsonPath().getString("booking.firstname"));
        System.out.println(response.jsonPath().getString("booking.bookingdates.checkout"));
        System.out.println(response.jsonPath().getInt("booking.totalprice"));

        Assert.assertEquals(response.jsonPath().getString("booking.additionalneeds"), "Breakfast");

//        To print all the fields from booking object from response

        JSONObject responseobject = new JSONObject(response.asString());

        System.out.println("Booking id is " + responseobject.getInt("bookingid"));
        System.out.println("Checkin date is " + responseobject.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin"));


    }

}
