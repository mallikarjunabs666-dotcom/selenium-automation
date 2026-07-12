package JulyAutomation;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class Practice1 {

    @Test
    void getuser() {

        when()
                .get("https://restful-booker.herokuapp.com/booking")

                .then()
                .statusCode(200)
                .log().all();

    }


    //    post request
    @Test
    void createuser() {

        HashMap<String, Object> data = new HashMap<>();
        data.put("firstname", "Malli");
        data.put("lastname", "BS");
        data.put("totalprice", 1234);
        data.put("depositpaid", true);

        HashMap<String, String> bookingdates1 = new HashMap<>();
        bookingdates1.put("checkin", "2018-01-01");
        bookingdates1.put("checkout", "2019-01-01");

        data.put("bookingdates", bookingdates1);
        data.put("additionalneeds", "Breakfast");


        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://restful-booker.herokuapp.com/booking")

                .then()
                .statusCode(200)
                .log().all();

    }

//    Post request body creation using hashmaps
//    body contains jasonobejct and jsob array ( Jsonarray inside jasonobject )

    @Test
    void jsonarrayinsidejsonobject() {

        HashMap<String, Object> data = new HashMap<>();
        data.put("userId", 1);

        HashMap<String, Object> product1 = new HashMap<>();
        product1.put("id", 144);
        product1.put("quantity", 4);

        HashMap<String, Object> producr2 = new HashMap<>();
        producr2.put("id", 98);
        producr2.put("quantity", 1);

        ArrayList<HashMap<String, Object>> productslist = new ArrayList<>();
        productslist.add(product1);
        productslist.add(producr2);

        data.put("products", productslist);


        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://dummyjson.com/carts/add")

                .then()
                .statusCode(201)
                .log().all()
                .body("total", equalTo(56044.95F))
                .body("discountedTotal", equalTo(53213))
                .body("totalProducts", equalTo(2))
                .body("totalQuantity", equalTo(5))
                .header("Server", "cloudflare")
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Connection", "keep-alive");

    }

//    Jsonobject inside jasonarray

    @Test
    void jsonobjectisiderootjsonarray() {

        ArrayList<HashMap<String, Object>> data = new ArrayList<>();

        HashMap<String, Object> user1 = new HashMap<>();
        user1.put("name", "Mallikarjun");
        user1.put("age", 31);
        user1.put("city", "Banglore");

        HashMap<String, Object> user2 = new HashMap<>();
        user2.put("name", "Rahul");
        user2.put("age", 30);
        user2.put("city", "Hyderabad");

        HashMap<String, Object> user3 = new HashMap<>();
        user3.put("name", "Ravi");
        user3.put("age", 28);
        user3.put("city", "Chennai");

        data.add(user1);
        data.add(user2);
        data.add(user3);

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("api reuqets here")

                .then()
                .statusCode(200);


    }


}
