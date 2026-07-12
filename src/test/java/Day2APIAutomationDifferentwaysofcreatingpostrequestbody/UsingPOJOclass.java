package Day2APIAutomationDifferentwaysofcreatingpostrequestbody;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UsingPOJOclass {

//    1st we need to create a object for POJO class


    @Test
    void postdatausingpojoclass()
    {

    PojoMainclass data = new PojoMainclass();

    data.setFirstname("Malli");
    data.setLastname("BS");
    data.setTotalprice(1234);
    data.setDepositpaid(true);

   Pojofordatebookings bookingdate = new Pojofordatebookings();

        data.setBookingdates(bookingdate);

   bookingdate.setCheckin("2018-01-02");
   bookingdate.setCheckout("2019-01-02");


        data.setAdditionalneeds("Breakfast");

        given()
                .contentType("application/json")
                .body(data)


                .when()
                .post("https://restful-booker.herokuapp.com/booking")


                .then()
                .statusCode(200);

}
}
