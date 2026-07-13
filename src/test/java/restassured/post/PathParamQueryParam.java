package restassured.post;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathParamQueryParam {


    @Test
    void simplePathParam() {
//        https://reqres.in/api/users/2

        given()
                .pathParam("id", 2)

                .when()
                .get("https://reqres.in/api/users/{id}")

                .then()
                .statusCode(200);


    }

    @Test
    void usingMultiplePathParams() {
//        Reuqest url : https://example.com/users/10/orders/20

        given()
                .pathParam("userid", 10)
                .pathParam("orderid", 20)

                .when()
                .get("https://example.com/users/{userid}/orders/{orderid}")

                .then()
                .statusCode(200);


    }

    @Test
    void usingQueryParam()
    {
//        https://reqres.in/api/users?page=2

        given()
                .queryParam("page", 2)

                .when()
                .get("https://reqres.in/api/users")

                .then()
                .statusCode(200);

    }
    @Test
    void usingMultipleQueryParams()
    {
//        https://example.com/products?category=mobile&limit=5

        given()
                .queryParam("category", "mobile")
                .queryParam("limit", 5)

                .when()
                .get("https://example.com/products")

                .then()
                .statusCode(200);

    }

    @Test
    void usingQueryParamsMethods()
    {
//        https://example.com/products?category=mobile&limit=5

        given()
                .queryParams("category", "mobile", "limit", 5, "sort", "asc" )

                .when()
                .get("https://example.com/products")

                .then()
                .statusCode(200);
    }

    @Test
    void usingBothQueryParamAndPathParam()
    {
//        https://dummyjson.com/products/category/smartphones?limit=5

        given()
                .pathParam("category", "smartphones")
                .queryParam("limit", 5)

                .when()
                .get("https://dummyjson.com/products/category/{category}")

                .then()
                .statusCode(200)
                .log().all();

    }



}
