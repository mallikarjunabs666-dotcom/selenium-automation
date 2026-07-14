package restassured.jsonparsing;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CompleteJsonParsing {

    @Test
    void JsonparsingInThenPart() {

        JSONObject body = new JSONObject();
        body.put("userId", 1);

        JSONObject product1 = new JSONObject();
        product1.put("id", 144);
        product1.put("quantity", 4);

        JSONObject product2 = new JSONObject();
        product2.put("id", 98);
        product2.put("quantity", 1);

        JSONArray productarray = new JSONArray();
        productarray.put(product1);
        productarray.put(product2);

        body.put("products", productarray);


        given()
                .contentType(ContentType.JSON)
                .body(body.toString())

                .when()
                .post("https://dummyjson.com/carts/add")

                .then()
                .statusCode(201)
                .header("server", "cloudflare")
                .body("id", equalTo(209))
                .body("products[0].quantity", equalTo(4))
                .body("products[1].title", equalTo("Cricket Helmet"))
                .body("totalQuantity", equalTo(5))
                .log().all()
                .log().headers()
                .log().cookies()
                .log().body();


    }

    @Test
    void jsonParsingUsingResponseVariable() {

        HashMap<String, Object> body = new HashMap<>();
        body.put("userId"/*/*/, 1);

        HashMap<String, Object> product1 = new HashMap<>();
        product1.put("id", 144);
        product1.put("quantity", 4);

        HashMap<String, Object> product2 = new HashMap<>();
        product2.put("id", 98);
        product2.put("quantity", 1);

        ArrayList<HashMap<String, Object>> productsarray = new ArrayList<>();
        productsarray.add(product1);
        productsarray.add(product2);

        body.put("products", productsarray);

        Response rs = given()
                .contentType(ContentType.JSON)
                .body(body)

                .when()
                .post("https://dummyjson.com/carts/add");

        Assert.assertEquals(rs.getStatusCode(), 201);

//        Single header validation using response variable

        String header = rs.header("server");
        System.out.println("Value of server header is " + header);
        Assert.assertEquals(header, "cloudflare");

//        to print all the header info

        Headers allheaders = rs.headers();

        for (Header h : allheaders) {
            System.out.println(h.getName() + " " + h.getValue());

        }

//        To get value of single field from json response

        String producttitle = rs.jsonPath().getString("products[0].title");
        System.out.println(producttitle);
        Assert.assertEquals(producttitle, "Rolex Submariner Watch");

    }

    boolean status = false;

    @Test
    void jsonParsingOfAllTheProducts() throws FileNotFoundException {
//            Creating post request body using external json library

        File f = new File(".//body.json");

        FileReader fr = new FileReader(f);

        JSONTokener jt = new JSONTokener(fr);

        JSONObject jo = new JSONObject(jt);

        Response rs = given()
                .contentType(ContentType.JSON)
                .body(jo.toString())

                .when()
                .post("https://dummyjson.com/carts/add");

//       to print title of all the products from json response body

        JSONObject responsebody = new JSONObject(rs.asString());

        JSONArray productsarray = responsebody.getJSONArray("products");

        for (int i = 0; i < productsarray.length(); i++) {
            String title = responsebody.getJSONArray("products").getJSONObject(i).getString("title");
            System.out.println(title);
        }

//        to check whether particular title is presen or not

        for (int i = 0; i < productsarray.length(); i++) {
            String producttitle = responsebody.getJSONArray("products").getJSONObject(i).getString("title");

            if (producttitle.equals("Rolex Submariner Watch")) {
                status = true;
                break;
            }
        }

        Assert.assertEquals(status, true);

//        to check the total discouted price of all the products

        JSONObject respsbody = new JSONObject(rs.asString());

        JSONArray producarrays = respsbody.getJSONArray("products");

        double totalDiscount = 0;
        for (int i = 0; i < producarrays.length(); i++) {
            double discountedprice = respsbody.getJSONArray("products").getJSONObject(i).getDouble("discountedPrice");
            totalDiscount = totalDiscount + discountedprice;
        }
        System.out.println(totalDiscount);

    }

    @Test
    void jsonParsingWithAllScenarios() {
        JSONObject data = new JSONObject();

        data.put("userId", 5);

        JSONObject product1 = new JSONObject();
        product1.put("id", 168);
        product1.put("quantity", 2);

        JSONObject product2 = new JSONObject();
        product2.put("id", 175);
        product2.put("quantity", 1);

        JSONObject product3 = new JSONObject();
        product3.put("id", 144);
        product3.put("quantity", 3);

        JSONArray productarray = new JSONArray();
        productarray.put(product1);
        productarray.put(product2);
        productarray.put(product3);

        data.put("products", productarray);

        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://dummyjson.com/carts/add")

                .then()
                .statusCode(201)
                .body("userId", equalTo(5))
                .body("totalProducts", equalTo(3))
                .body("totalQuantity", equalTo(6));

    }

//    Headers verification using testng assertions

    @Test
    void headersVerficaition() {
        JSONObject data = new JSONObject();

        data.put("userId", 5);

        JSONObject product1 = new JSONObject();
        product1.put("id", 168);
        product1.put("quantity", 2);

        JSONObject product2 = new JSONObject();
        product2.put("id", 175);
        product2.put("quantity", 1);

        JSONObject product3 = new JSONObject();
        product3.put("id", 144);
        product3.put("quantity", 3);

        JSONArray productarray = new JSONArray();
        productarray.put(product1);
        productarray.put(product2);
        productarray.put(product3);

        data.put("products", productarray);

        Response rs = given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://dummyjson.com/carts/add");

        Assert.assertEquals(rs.header("Content-Type"), "application/json; charset=utf-8");
        Assert.assertEquals(rs.header("server"), "cloudflare");

        System.out.println(rs.jsonPath().getString("total"));
        System.out.println(rs.jsonPath().getString("discountedTotal"));
        System.out.println(rs.jsonPath().getString("userId"));
        System.out.println(rs.jsonPath().getString("id"));

        JSONObject ob = new JSONObject(rs.asString());
        JSONArray productsarray = ob.getJSONArray("products");

//        Loop through the products array and print:

        for (int i = 0; i < productsarray.length(); i++) {
            int productid = ob.getJSONArray("products").getJSONObject(i).getInt("id");
            String producttitle = ob.getJSONArray("products").getJSONObject(i).getString("title");
            double productprice = ob.getJSONArray("products").getJSONObject(i).getDouble("price");
            int productquantity = ob.getJSONArray("products").getJSONObject(i).getInt("quantity");
            double productdiscount = ob.getJSONArray("products").getJSONObject(i).getDouble("discountPercentage");
            System.out.println("Product ID :" + productid);
            System.out.println("Product Title :" + producttitle);
            System.out.println("Price :" + productprice);
            System.out.println("Quantity :" + productquantity);
            System.out.println("Discount Percentage :" + productdiscount);
        }

//        Verify there are exactly 3 products.
        Assert.assertEquals(productsarray.length(), 3);
        Assert.assertEquals(rs.jsonPath().getInt("totalQuantity"), 6);

        System.out.println(ob.getInt("id"));
        System.out.println(ob.getInt("userId"));
        System.out.println(ob.getInt("total"));



    }
}
