package restassured.post;

import groovy.json.JsonToken;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestBodyUsingExternalJsonFile {

    @Test
    void usingExternalJsonLibrary() throws FileNotFoundException {

//comes from java.io package
// It does not open or read the file.
//It simply tells Java:
//"This file exists at this location."
//Think of it as storing the file's address.

        File f = new File(".\\body.json");

//       It opens the file and starts reading it, below line
        FileReader fr = new FileReader(f);

//reads JSON character by character and breaks it into JSON token
//It prepares the data so that JSONObject can understand the JSON structure.
        JSONTokener jt = new JSONTokener(fr);

//Now the actual JSON object is created.
//JSONObject reads everything from the JSONTokener.
        JSONObject data = new JSONObject(jt);

        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://restful-booker.herokuapp.com/booking")

                .then()
                .statusCode(200)
                .log().all()
                .body("booking.firstname", equalTo("Jim"))
                .body("booking.bookingdates.checkin", equalTo("2018-01-01"))
                .header("Server", "Heroku")
                .header("Content-Type", "application/json; charset=utf-8");


    }
}
