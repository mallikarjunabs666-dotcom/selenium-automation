package restassured.jsonparsing;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ValidatingMultipleFieldsFromJsonBody {

//    Using Jsobobject class

    boolean status = false;
    @Test
    void JsonparsingusingJsobObject() {

        Response rs = given()

                .when()
                .get("https://dummyjson.com/carts/1");

        JSONObject jo = new JSONObject(rs.asString());

//        to print all the titles from the response, we use for loop

        JSONArray productsarray = jo.getJSONArray("products");

        for (int i = 0; i < productsarray.length(); i++) {
            String producttile = jo.getJSONArray("products").getJSONObject(i).get("title").toString();
            System.out.println(producttile);

            //        to check particular product title is present or not

            if (producttile.equals("Generic Motorcycle"))
            {
                status=true;
                break;
            }

        }
        Assert.assertEquals(status, true);
        System.out.println("Required title is present");
    }

//    to check the total price of all the products

    double totalprice = 0;
    @Test
    void productsTotalPrice()
    {
       Response rs = given()

                .when()
                .get("https://dummyjson.com/carts/1");

       JSONObject jo =new JSONObject(rs.asString());

      JSONArray jr = jo.getJSONArray("products");

      for (int i = 0; i<jr.length(); i++)
      {
         String price =  jo.getJSONArray("products").getJSONObject(i).get("price").toString();
         totalprice = totalprice+Double.parseDouble(price);
      }
        System.out.println("total products price " + totalprice);
      Assert.assertEquals(totalprice, 4338.959999999999);

    }

}
