package restassured.fileuploadanddownload;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class MultipleFileUpload {

    @Test
    void multpleFile()
    {
        File myfile1 = new File("C:/Users/Dell/Downloads/Mallikarjuna(1).pdf");
        File myfile2 = new File("C:/Users/Dell/Downloads/Malli resume (4).pdf");

        File filearray[] = {myfile1, myfile2};

        given()
                .multiPart("file", filearray)

                .when()
                .post("https://postman-echo.com/post")

                .then()
                .statusCode(200)
                .log().all();


    }
}
