package Day4APITesting;

import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class jsonvalidation {

    // Jsonvalidation/jsonprsing
//APproach 1

    Boolean status = false;
    int totalid = 0;


    @Test
    void jasonresponseparsin() {

        HashMap<String, Object> data = new HashMap<>();

        data.put("firstname", "Malli");
        data.put("lastname", "BS");
        data.put("totalprice", 1234);
        data.put("depositpaid", true);

        HashMap<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        data.put("bookingdates", bookingdates);

        data.put("additionalneeds", "Lunch");

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://restful-booker.herokuapp.com/booking")

                .then()
                .statusCode(200)
                .log().all()

//                    If we have small data verification we gor for this approach
                .body("booking.firstname", equalTo("Malli"))
                .body("booking.bookingdates.checkin", equalTo("2018-01-01"));


    }


//  Approach 2, storing json response in a variable and validating using that response variable

    @Test
    void jsonparsingusingresponsevariable() {

        HashMap<String, Object> data = new HashMap<>();

        data.put("firstname", "Malli");
        data.put("lastname", "BS");
        data.put("totalprice", 1234);
        data.put("depositpaid", true);

        HashMap<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        data.put("bookingdates", bookingdates);

        data.put("additionalneeds", "Lunch");

        Response rs = given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://restful-booker.herokuapp.com/booking");


//   If we have large data in json/xmal response and want to validate multiple things
//    we stpre the response in a response variable and do all the validation


        Assert.assertEquals(rs.getStatusCode(), 200);
        Assert.assertEquals(rs.header("Content-Type"), "application/json; charset=utf-8");

//  to verify specific field in json path

        String name = rs.jsonPath().get("booking.firstname").toString();
        System.out.println(name);

        Assert.assertEquals(name, "Malli");

        String checkingdate = rs.jsonPath().get("booking.bookingdates.checkin").toString();

        Assert.assertEquals(checkingdate, "2018-01-01");


    }


//    Example with Jsonobject with Jsonarray

//    json response
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
    void jsonparsing1()
    {
     Response rs =   given()


                .when()
                .post("url here");

//     IF i want to print all the roles from the above json response
//        1st need to create a object for json class

        JSONObject js = new JSONObject(rs.asString());

//        since response is in response formate, we need to convert response in to string while sending to jsonobject

        for (int i = 0; i<js.getJSONArray("employees").length(); i++)
        {

         String role =   js.getJSONArray("employees").getJSONObject(i).get("role").toString();

            System.out.println(role);

//            to check particular role is available or not
            if (role.equals("Developer"))
            {
                status=true;
                break;
            }

        }
        Assert.assertEquals(status, true);

//        to count all the id's from the json response

        for (int i = 0; i<js.getJSONArray("employees").length(); i++)
        {
         String id =    js.getJSONArray("employees").getJSONObject(i).get("id").toString();

            totalid=totalid+Integer.parseInt(id);

        }

        System.out.println("total id's" + totalid);

        Assert.assertEquals(totalid, 200);

    }
}
