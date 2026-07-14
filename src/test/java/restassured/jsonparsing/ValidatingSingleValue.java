package restassured.jsonparsing;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ValidatingSingleValue {

    @Test
    void singleResponse() {
        given()

                .when()
                .get("https://dummyjson.com/carts/1")

                .then()
                .body("id", equalTo(1))
                .body("total", equalTo(13037.88F))
                .body("totalQuantity", equalTo(12))
                .body("products[1].title", equalTo("Generic Motorcycle"))
                .log().body();

    }

    //    Validating single json response using assertions
    @Test
    void validationusingassertions() {
        Response bodyinfo = given()

                .when()
                .get("https://dummyjson.com/carts/1");

        Assert.assertEquals(bodyinfo.getStatusCode(), 200);
        Assert.assertEquals(bodyinfo.getHeader("content-type"), "application/json; charset=utf-8");
        Assert.assertEquals(bodyinfo.getHeader("server"), "cloudflare");

    }

//    To get to the specific field in json path

    @Test
    void responseBodyValidationsUsingAssertions() {

        Response rs = given()

                .when()
                .get("https://dummyjson.com/carts/1");

        String title = rs.jsonPath().getJsonObject("products[2].title").toString();
        Assert.assertEquals(title, "iPhone 6");
        System.out.println(title);


    }

}
