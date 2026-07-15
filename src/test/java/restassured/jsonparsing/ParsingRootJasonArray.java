package restassured.jsonparsing;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ParsingRootJasonArray {

    //
    @Test
    void jsonArray() {
        JSONObject user1 = new JSONObject();
        user1.put("id", 101);
        user1.put("name", "John");
        user1.put("age", 25);

        JSONObject user2 = new JSONObject();
        user2.put("id", 102);
        user2.put("name", "David");
        user2.put("age", 30);

        JSONArray data = new JSONArray();
        data.put(user1);
        data.put(user2);

        Response rs = given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("url here");

        JSONArray ar = new JSONArray(rs.asString());
//       to print all the users from the array

        for (int i = 0; i < ar.length(); i++) {
            System.out.println(ar.getJSONObject(i).getString("name"));
        }


    }

    @Test
    void test()
    {
        JSONArray data = new JSONArray();
        data.put("Java");
        data.put("Selenium");
        data.put("REST Assured");

       Response rs =  given()
               .contentType("application/json")
               .body(data.toString())

                .when()
                .post("url here");

        Assert.assertEquals(rs.statusCode(), 201);
//        to print all the values from json array

        JSONArray ar = new JSONArray(rs.asString());
        for (int i = 0; i<ar.length(); i++)
        {
            System.out.println(ar.getString(i));
        }


    }

}
