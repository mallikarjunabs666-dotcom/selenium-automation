package restassured.fileuploadanddownload;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SingleFileUpload {

    @Test
    void singleFileUpload()
    {
        File myfile = new File("C:/Users/Dell/Downloads/Mallikarjuna(1).pdf");

        given()
                .multiPart("file", myfile)

                .when()
                .post("https://postman-echo.com/post")

                .then()
                .statusCode(200)
//                .body("filename", equalTo("Mallikarjuna(1)"))
                .log().body();

    }
}
