package restassured.jsonparsing;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingWithRootJsonObject {

    @Test
    void parsingOfJsonObject() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("userId", 10);


        JSONObject user1 = new JSONObject();
        user1.put("id", 144);
        user1.put("quantity", 2);

        JSONObject user2 = new JSONObject();
        user2.put("id", 98);
        user2.put("quantity", 3);

        JSONObject user3 = new JSONObject();
        user3.put("id", 121);
        user3.put("quantity", 1);

        JSONArray products = new JSONArray();
        products.put(user1);
        products.put(user2);
        products.put(user3);

        requestBody.put("products", products);

        Response rs = given()
                .contentType("application/json")
                .body(requestBody.toString())

                .when()
                .post("https://dummyjson.com/carts/add")

                .then()
                .extract().response();

        Assert.assertEquals(rs.getStatusCode(), 201);
        Assert.assertEquals(rs.jsonPath().getInt("userId"), 10);
        Assert.assertEquals(rs.jsonPath().getInt("totalProducts"), 3);
        Assert.assertEquals(rs.jsonPath().getInt("totalQuantity"), 6);
        Assert.assertEquals(rs.header("content-type"), "application/json; charset=utf-8");
        Assert.assertEquals(rs.header("server"), "cloudflare");

//        Json parsing

        JSONObject jo = new JSONObject(rs.asString());

        System.out.println("cart id is " + jo.getInt("id"));
        System.out.println("user id is " + jo.getInt("userId"));
        System.out.println("Total is " + jo.getDouble("total"));
        System.out.println("discountedTotal is " + jo.getInt("discountedTotal"));

//        loop through products and print everything

        JSONArray product = jo.getJSONArray("products");

        for (int i = 0; i < product.length(); i++) {

            JSONObject productlist = product.getJSONObject(i);
            System.out.println("Product id is " + productlist.getInt("id"));
            System.out.println("Title is " + productlist.getString("title"));
            System.out.println("Price is " + productlist.getDouble("price"));
            System.out.println("Quanity is " + productlist.getInt("quantity"));
            System.out.println("total is " + productlist.getDouble("total"));
            System.out.println("Discount percentage is " + productlist.getDouble("discountPercentage"));
        }

//       To verify thr are exactly 3 products
        Assert.assertEquals(product.length(), 3);

//       To verify quanity is 6

        Assert.assertEquals(rs.jsonPath().getInt("totalQuantity"), 6);

//        Verify one of the product is Rolex Submariner Watch"
        boolean status = false;
        for (int i = 0; i < product.length(); i++) {
            JSONObject productslists = product.getJSONObject(i);

            String title = productslists.getString("title");
            if (title.equals("Rolex Submariner Watch")) {
                status = true;
                break;
            }

        }
        Assert.assertTrue(status, "Rolex Submariner Watch");

    }
}
