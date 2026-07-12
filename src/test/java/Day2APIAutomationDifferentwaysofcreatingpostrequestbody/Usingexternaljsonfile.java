package Day2APIAutomationDifferentwaysofcreatingpostrequestbody;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class Usingexternaljsonfile {

@Test
    void usingjsonfile() throws FileNotFoundException {

//    to get the data from the external file 1st we need to open the file

    File f = new File(".\\body.json"); // comes fro java

    // to read the data from the file we use special class filereader

    FileReader fr = new FileReader(f); // comes from java.io

    JSONTokener jt = new JSONTokener(fr);

    JSONObject data = new JSONObject(jt);

    given()
            .contentType("application/json")
            .body(data.toString())

            .when()
            .post("https://restful-booker.herokuapp.com/booking")

            .then()
            .statusCode(200);


}
}
