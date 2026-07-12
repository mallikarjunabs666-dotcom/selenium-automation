package Interviewpractise;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.bouncycastle.math.raw.Nat.equalTo;

public class Jsonparsing {

    boolean status = false;

    int totalids ;

    @Test
    void jsonparsing()
    {

        HashMap<String, Object> data = new HashMap<>();
        data.put("firstname", "Malli");
        data.put("lastname", "BS");
        data.put("totalprice", 1234);
        data.put("depositpaid", true);

        HashMap<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        data.put("bookingdates", bookingdates );
        data.put("additionalneeds", "Dinner");

      Response rs =   given()
                .contentType(ContentType.JSON)
                .body(data)

                .when()
                .post("https://restful-booker.herokuapp.com/booking");

//                .then()
//                .statusCode(200)
//
////                If we have small data verification in body, we go for this approach
//                .body("booking.firstname", equalTo("Malli"))
//                .body("booking.bookingdates.checkin", equalTo("2018-01-01"));


//        If we want to verify large data in json/xmal response
//        we need to store response in response variable and validate it

       Assert.assertEquals(rs.getStatusCode(), 200);
//       Assert.assertEquals(rs.header("header name"), "expected value");

//        to get the values of the particular field from response body

       String name =  rs.jsonPath().get("booking.firstname").toString();

       Assert.assertEquals(name, "Malli");
    }

//    dummy exmaple to print all the roles in the below json
//{
//    "company": "ABC Technologies",
//        "location": "Bangalore",
//
//        "employees": [
//    {
//        "id": 101,
//            "name": "Malli",
//            "role": "QA Engineer"
//    },
//    {
//        "id": 102,
//            "name": "Rahul",
//            "role": "Developer"
//    }
//  ]
//}


    @Test
    void jsonpars()
    {


       Response rs =  given()
                .contentType("application/json")

                .when()
                .get("dummy url");

//        to print all the roles in the above json

        JSONObject jo = new JSONObject(rs.asString());

        for(int i = 0; i<jo.getJSONArray("employees").length(); i++)
        {

          String role =   jo.getJSONArray("employees").getJSONObject(i).get("role").toString();

            System.out.println(role);

//          toprint check role is avaibale or not

            if (role.equals("QA Engineer"))
            {
                status = true;
                return;
            }
        }

        Assert.assertEquals(status, true);

//        to print the sum if id's from the above json
        for (int i = 0; i<jo.getJSONArray("employees").length(); i++)
        {
           String id =  jo.getJSONArray("employees").getJSONObject(i).get("id").toString();
            totalids = totalids+Integer.parseInt(id);
        }
        System.out.println(totalids);


    }
}
