package restassured.interviewpractice;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostRequestBodyUsingHashMap {

    @Test
    void requestBodyUsingHashMap() {

        HashMap<String, Object> data = new HashMap<>();
        data.put("userId", 25);

        HashMap<String, Object> shippingAdress = new HashMap<>();
        shippingAdress.put("name", "Mallikarjuna");
        shippingAdress.put("city", "Bangalore");
        shippingAdress.put("state", "Karnataka");
        shippingAdress.put("pincode", "560100");

        data.put("shippingAddress", shippingAdress);

        HashMap<String, Object> product1 = new HashMap<>();
        product1.put("id", 1);
        product1.put("quantity", 2);

        HashMap<String, Object> product2 = new HashMap<>();
        product2.put("id", 5);
        product2.put("quantity", 4);

        HashMap<String, Object> product3 = new HashMap<>();
        product3.put("id", 9);
        product3.put("quantity", 1);

        ArrayList<HashMap<String, Object>> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        data.put("products", products);

        HashMap<String, Object> payment = new HashMap<>();
        payment.put("method", "UPI");
        payment.put("status", "Pending");

        data.put("payment", payment);

        System.out.println(data);

        Response response = given()
                .log().body()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://dummyjson.com/carts/add")

                .then()
                .extract().response();

        System.out.println(response.getStatusCode());
        System.out.println(response);
        System.out.println(response.jsonPath().getInt("userId"));

//        Print the total number of products returned.

        JSONObject responseobject = new JSONObject(response.asString());

        System.out.println("Total number of products retured is " + responseobject.getJSONArray("products").length());

//        Print the quantity of the second product.

        System.out.println("Quantity of second product is " + responseobject.getJSONArray("products").getJSONObject(1).getInt("quantity"));

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.header("Content-Type"), "Header value here");
        Assert.assertTrue(response.jsonPath().getInt("id") > 0);
        Assert.assertEquals(responseobject.getJSONArray("products").getJSONObject(0).getInt("quantity"), 1);

    }

}
