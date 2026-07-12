package Interviewpractise;

import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class Day1interviewpractise {


    @Test
    void postdatausinghashmap() {
//        Using simple json

        HashMap<String, Object> data = new HashMap<>();
        data.put("firstname", "Malli");
        data.put("lastname", "BS");
        data.put("totalprice", 1234);
        data.put("depositpaid", true);

        HashMap<String, String> bookingdate = new HashMap<>();
        bookingdate.put("checkin", "2018-01-01");
        bookingdate.put("checkout", "2019-01-01");

        data.put("bookingdates", bookingdate);
        data.put("additionalneeds", "Breakfast");

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://restful-booker.herokuapp.com/booking")

                .then()
                .statusCode(200)
                .body("booking.firstname", equalTo("Malli"))
                .body("booking.bookingdates.checkin", equalTo("2018-01-01"))
                .log().all()
                .log().body()
                .log().headers()
                .log().cookies();
    }

    @Test
    void complextjsonrequestbody() {

//        Request bodu creation using hashmaps

        HashMap<String, Object> data = new HashMap<>();

        data.put("employeeId", 101);
        data.put("employeeName", "Malli");
        data.put("department", "QA");

        HashMap<String, Object> adress = new HashMap<>();

        adress.put("city", "Banglore");
        adress.put("state", "Karnataka");
        adress.put("pincode", 560001);

        data.put("address", adress);


        String skill[] = {"Java", "Selenium", "REST Assured", "TestNG"};

        data.put("skills", skill);


        HashMap<String, Object> projectdetails1 = new HashMap<>();
        projectdetails1.put("projectId", "P1001");
        projectdetails1.put("projectName", "E-Commerce Automation");

        HashMap<String, Object> projectdetails2 = new HashMap<>();
        projectdetails2.put("projectId", "P1002");
        projectdetails2.put("projectName", "API Automation Framework");

        ArrayList projects = new ArrayList();
        projects.add(projectdetails1);
        projects.add(projectdetails2);

        data.put("projects", projects);

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("url here")

                .then()
                .statusCode(200)
                .body("employeeId", equalTo(101))
                .body("address.city", equalTo("Bangalore"))
                .body("skills[0]", equalTo("Java"))
                .body("skills", hasItems("Java", "Selenium"))
                .body("projects[0].projectId", equalTo("P1001"));

    }
    @Test
    void postrequestusingorgjson()
    {

        JSONObject data = new JSONObject();

        data.put("employeeId", 101);
        data.put("employeeName", "Malli");
        data.put("department", "QA");

        JSONObject adress = new JSONObject();
        adress.put("city", "Bangalore");
        adress.put("state", "Karnataka");
        adress.put("pincode", 560001);

        data.put("address", adress );

        String[] skillls = {"Java", "Selenium", "REST Assured", "TestNG"};

        data.put("skills", skillls);

        JSONObject project1 = new JSONObject();
        project1.put("projectId", "P1001");
        project1.put("projectName", "E-Commerce Automation");

        JSONObject project2 = new JSONObject();
        project2.put("projectId", "P1002");
        project2.put("projectName", "API Automation Framework");

        List<Object> project = new ArrayList<>();

        project.add(project1);
        project.add(project2);

        data.put("projects", project );

        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("url here")

                .then()
                .statusCode(201);
    }

    @Test
    void usingpojoclass1()
    {



    }


}
