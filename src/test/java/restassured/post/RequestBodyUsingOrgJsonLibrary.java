package restassured.post;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class RequestBodyUsingOrgJsonLibrary {

    @Test
    void postRequestBodyUsingOrgJson()
    {

//    1st we have to create a json object

        JSONObject requestBody = new JSONObject();

        requestBody.put("userId", 1);

        JSONObject product1 = new JSONObject();
        product1.put("id", 144);
        product1.put("quantity", 4);

        JSONObject product2 = new JSONObject();
        product2.put("id", 98);
        product2.put("quantity", 1);

        JSONArray prodctslist = new JSONArray();
        prodctslist.put(product1);
        prodctslist.put(product2);

        requestBody.put("products", prodctslist);

        given()
                .contentType("application/json")
                .body(requestBody.toString())

                .when()
                .post("https://dummyjson.com/carts/add")

                .then()
                .statusCode(201);


    }


}
