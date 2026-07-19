package selenium;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APIinterview {

    @Test
    void createBooking() {
        JSONObject data = new JSONObject();
        data.put("firstname", "Jim");
        data.put("lastname", "Brown");
        data.put("totalprice", 111);
        data.put("depositpaid", true);

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        data.put("bookingdates", bookingdates);

        data.put("additionalneeds", "Breakfast");

        Response rs = given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://restful-booker.herokuapp.com/booking");

        Assert.assertEquals(rs.getStatusCode(), 200);

        JSONObject response = new JSONObject(rs.asString());

        String additionaldata = response.getJSONObject("booking").getString("additionalneeds");
        Assert.assertEquals(additionaldata, "Breakfast");


    }
}
