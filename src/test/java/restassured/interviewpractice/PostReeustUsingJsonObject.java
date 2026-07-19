package restassured.interviewpractice;

import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PostReeustUsingJsonObject {

    @Test
    void requestBodyUsingJsonObject() {
        JSONObject requestbody = new JSONObject();

        JSONObject customer = new JSONObject();
        customer.put("customerId", 501);
        customer.put("name", "Mallikarjuna");

        JSONObject membership = new JSONObject();
        membership.put("type", "Gold");
        membership.put("expiry", "2027-12-31");

        JSONArray benifits = new JSONArray();
        benifits.put("Free Delivery");
        benifits.put("Priority Support");
        benifits.put("Cashback");

        membership.put("benefits", benifits);

        customer.put("membership", membership);

        requestbody.put("customer", customer);

        JSONObject shipping = new JSONObject();

        requestbody.put("shipping", shipping);

        JSONObject adress = new JSONObject();
        adress.put("houseNo", "21A");
        adress.put("street", "MG Road");
        adress.put("city", "Bangalore");
        adress.put("state", "Karnataka");
        adress.put("country", "India");
        adress.put("postalCode", "560001");

        shipping.put("shipping", adress);

        JSONObject contact = new JSONObject();
        contact.put("mobile", "9876543210");
        contact.put("alternate", "9988776655");

        shipping.put("contact", contact);

        JSONArray orders = new JSONArray();

        JSONObject order1 = new JSONObject();
        order1.put("orderId", 1001);

        JSONObject waterhouse1 = new JSONObject();
        waterhouse1.put("warehouseId", 11);
        waterhouse1.put("location", "Bangalore");

        order1.put("warehouse", waterhouse1);

        JSONArray items = new JSONArray();

        JSONObject item1 = new JSONObject();

        item1.put("productId", 101);
        item1.put("name", "Laptop");
        item1.put("quantity", 1);
        item1.put("price", 70000);

        JSONObject item2 = new JSONObject();
        item2.put("productId", 102);
        item2.put("name", "Mouse");
        item2.put("quantity", 2);
        item2.put("price", 500);

        JSONArray offerforitem2 = new JSONArray();

        item2.put("offers", offerforitem2);


        JSONArray offers = new JSONArray();

        JSONObject offer1 = new JSONObject();
        offer1.put("offerId", "O1");
        offer1.put("discount", 5000);

        JSONObject offer2 = new JSONObject();
        offer2.put("offerId", "O2");
        offer2.put("discount", 2000);

        offers.put(offer1);
        offers.put(offer2);

        item1.put("offers", offers);

        items.put(item1);
        items.put(item2);

        order1.put("items", items);

        orders.put(order1);

        requestbody.put("orders", orders);

        System.out.println(requestbody);

        given()
                .log().body()
                .contentType("application/json")
                .body(requestbody.toString())

                .when()
                .post("https://api.company.com/v1/orders/create")

                .then()
                .statusCode(201);

    }
}
