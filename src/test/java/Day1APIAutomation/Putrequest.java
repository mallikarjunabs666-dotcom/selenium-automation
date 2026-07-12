package Day1APIAutomation;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Putrequest {

    // to update something in put request, 1st we need capture the id  in the post request,
    // then we can use this attribute to update in the put request

    String token;
    int id;

    @Test(priority = 1)
    void createbookings() {

        HashMap<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2026-01-02");
        bookingdates.put("checkout", "2026-01-02");

        HashMap<String, Object> data = new HashMap<>();
        data.put("firstname", "MBS");
        data.put("lastname", "Arjun");
        data.put("totalprice", 1234);
        data.put("depositpaid", true);
        data.put("bookingdates", bookingdates);
        data.put("additionalneeds", "Lunch");

        id = given()
                .contentType("application/json")
                //content type means what type of data we are sending, and we are sending in jason format

                .body(data)

                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                //after sending post request, it will send some respose, on that response we are doing the validation
                // i dont want to do any validation, but i want to capture the response in a variable.

                .jsonPath().getInt("bookingid");
        //response is in json format, that's why we are using jason above
        // from the jasonpath we have to get users id, that's why using getint method
        //above startement wrtitten some value, we need to store, that's why before given section we have to create a variable.

        System.out.println(id);

    }

    @Test(priority = 2)
    void createtoken()
    {
        HashMap<String,String> authdata = new HashMap<>();

        authdata.put("username","admin");
        authdata.put("password","password123");

        token = given()
                .contentType("application/json")
                .body(authdata)

                .when()
                .post("https://restful-booker.herokuapp.com/auth")

                .jsonPath().getString("token");

        System.out.println(token);
    }

    @Test(priority = 3, dependsOnMethods = {"createbookings", "createtoken"})
    void updatebooking()
    {

        HashMap<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2026-01-02");
        bookingdates.put("checkout", "2026-01-02");

        HashMap<String, Object> data = new HashMap<>();
        data.put("firstname", "Mallik");
        data.put("lastname", "Arjun BS");
        data.put("totalprice", 1234);
        data.put("depositpaid", true);
        data.put("bookingdates", bookingdates);
        data.put("additionalneeds", "Dinner");


        given()
                .contentType("application/json")
                .cookie("token", token)
                .body(data)

                .when()
                .put("https://restful-booker.herokuapp.com/booking/"+id)


                .then()
                .statusCode(200)
                .log().all();

    }


     @Test(priority = 4)
    void deletebooking()

    {
        given()
                .cookie("token", token)

                .when()
                .delete("https://restful-booker.herokuapp.com/booking/"+id)


                .then()
                .statusCode(201)
                .log().all();
    }
}

//A 403 Forbidden error means:
//Request reached the server
//But the server is refusing permission