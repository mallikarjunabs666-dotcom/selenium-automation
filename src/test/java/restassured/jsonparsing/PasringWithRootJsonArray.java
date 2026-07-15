package restassured.jsonparsing;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PasringWithRootJsonArray {

    @Test
    void parsingJsonArray() {
        JSONObject user1 = new JSONObject();
        user1.put("id", 101);
        user1.put("name", "John");
        user1.put("age", 25);
        user1.put("department", "QA");

        JSONObject user2 = new JSONObject();
        user2.put("id", 102);
        user2.put("name", "David");
        user2.put("age", 30);
        user2.put("department", "Automation");

        JSONObject user3 = new JSONObject();
        user3.put("id", 103);
        user3.put("name", "Steve");
        user3.put("age", 28);
        user3.put("department", "Performance");

        JSONArray users = new JSONArray();
        users.put(user1);
        users.put(user2);
        users.put(user3);

        Response response = given()
                .contentType("application/json")
                .body(users.toString())

                .when()
                .post(" https://example.com/api/employees")


                .then()
                .statusCode(201)
                .header("Content-Type", "header value here")
                .header("Server", "server value here")
                .extract().response();

        JSONArray jsonresponse = new JSONArray(response.asString());

        for (int i = 0; i < jsonresponse.length(); i++) {
            JSONObject jo = jsonresponse.getJSONObject(i);

            System.out.println(jo.getInt("id"));
            System.out.println(jo.getString("name"));
            System.out.println(jo.getInt("age"));
            System.out.println(jo.getString("department"));
            System.out.println(jo.getString("status"));

        }

        Assert.assertEquals(jsonresponse.length(), 3);

//       Verify employee John exists
        boolean employeename = false;
        for (int i = 0; i < jsonresponse.length(); i++) {
            JSONObject objects = jsonresponse.getJSONObject(i);

            if (objects.getString("name").equals("John")) {
                employeename = true;
                break;
            }

        }
        Assert.assertTrue(employeename, "Employee john doesnot exists");

//        Verify every employee has "status": "Created"

        int count = 0;
        for (int i = 0; i < jsonresponse.length(); i++) {
            if (jsonresponse.getJSONObject(i).getString("status").equals("Created")) {
                count++;
            }
        }

        Assert.assertEquals(count, 3);


    }


}
