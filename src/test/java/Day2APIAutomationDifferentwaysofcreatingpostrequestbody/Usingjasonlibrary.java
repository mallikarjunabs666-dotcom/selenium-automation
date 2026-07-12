package Day2APIAutomationDifferentwaysofcreatingpostrequestbody;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Usingjasonlibrary {

    @Test
    void postdatausingjasoblibrary() {

        JSONObject data = new JSONObject();

        data.put("firstname", "Malli");
        data.put("lastname", "BS");
        data.put("totalprice", 1234);
        data.put("depositpaid", true);

        JSONObject bookingdatesdata = new JSONObject();
        bookingdatesdata.put("checkin", "2026-01-02");
        bookingdatesdata.put("checkout", "2026-01-03");

        data.put("bookingdates", bookingdatesdata);

        data.put("additionalneeds", "Breakfast");


        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://restful-booker.herokuapp.com/booking")


                .then()
                .statusCode(200)
                .body("booking.firstname", equalTo("Malli"))
                        .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", equalTo("2026-01-02"));





    }
}