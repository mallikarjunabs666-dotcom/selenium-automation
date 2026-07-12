package Day5APITesting;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class xmlresponsetraversing {

    boolean status = false;

    @Test
    void xmlresposne() {

// 1st approach, xml verfification in then method
        given()

                .when()
                .get("https://www.w3schools.com/xml/simple.xml")


                .then()
                .statusCode(200)
                .body("breakfast_menu.food[0].name", equalTo("Belgian Waffles"));
    }


    @Test
    void xmltraversingusingresponsevariable() {

//        Approach 2, validations using response variable

        Response rs = given()

                .when()
                .get("https://www.w3schools.com/xml/simple.xml");

        Assert.assertEquals(rs.statusCode(), 200);

        String calories = rs.xmlPath().get("breakfast_menu.food[1].calories").toString();
        Assert.assertEquals(calories, "900");

//        to get total number of food items

        XmlPath xm = new XmlPath(rs.asString());

       List<String> fooditems =  xm.getList("breakfast_menu.food.name");

        System.out.println(fooditems.size());

//        to check particular food item is presen or not

        for(String fooditem : fooditems)

        {
            System.out.println(fooditem);

            if (fooditem.equals("Homestyle Breakfast"))
            {
                status=true;
                break;
            }
        }

        Assert.assertEquals(status, true);

    }

}
