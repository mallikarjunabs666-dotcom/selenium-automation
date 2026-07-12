//package Interviewpractise;
//
//import io.restassured.http.Header;
//import io.restassured.http.Headers;
//import io.restassured.response.Response;
//import org.json.JSONTokener;
//import org.testng.annotations.Test;
//
//import org.json.JSONObject;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.HashMap;
//import java.util.Map;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//
//public class APIAUtomationpractice {
//
//    int bookingnumber;
//
//    String token;
//
//    @Test(priority = 1)
//    void getrequest() {
//
//        given()
//
//                .when().get("https://restful-booker.herokuapp.com/booking")
//
//
//                .then().statusCode(200).log().body();
//
//    }
//
//    @Test(priority = 2)
//    void postrequest() {
//
//        HashMap<String, Object> data = new HashMap<>();
//
//        data.put("firstname", "Malli");
//        data.put("lastname", "BS");
//        data.put("totalprice", 1234);
//        data.put("depositpaid", true);
//
//        HashMap<String, String> bookingdates = new HashMap<>();
//        bookingdates.put("checkin", "2018-01-01");
//        bookingdates.put("checkout", "2019-01-01");
//
//        data.put("bookingdates", bookingdates);
//
//        data.put("additionalneeds", "Lunch");
//
//
//        bookingnumber = given().contentType("application/json").body(data)
//
//                .when().post("https://restful-booker.herokuapp.com/booking").jsonPath().getInt("bookingid");
//
////            .then()
////            .statusCode(200)
////            .log().body();
//
//    }
//
//
//    @Test
//    void createtoken() {
//
//        HashMap<String, String> data = new HashMap<>();
//
//        data.put("username", "admin");
//        data.put("password", "password123");
//
//        token = given().contentType("application/json").body(data)
//
//                .when().post("https://restful-booker.herokuapp.com/auth").jsonPath().getString("token");
//
//    }
//
//
//    @Test(priority = 3, dependsOnMethods = {"postrequest", "createtoken"})
//    void putrequest()
//// to update something in the put request, 1st we need to capture id from post request
//    {
//        HashMap<String, Object> data = new HashMap<>();
//
//        data.put("firstname", "Malli");
//        data.put("lastname", "BS");
//        data.put("totalprice", 5789);
//        data.put("depositpaid", true);
//
//        HashMap<String, String> bookingdates = new HashMap<>();
//        bookingdates.put("checkin", "2018-01-01");
//        bookingdates.put("checkout", "2019-01-01");
//
//        data.put("bookingdates", bookingdates);
//
//        data.put("additionalneeds", "Lunch");
//
//        given().contentType("application/json").body(data).cookie("token", token)
//
//                .when().put("https://restful-booker.herokuapp.com/booking/" + bookingnumber)
//
//
//                .then().statusCode(200).log().body();
//
//
//    }
//
//
//    @Test(priority = 4, dependsOnMethods = {"postrequest", "createtoken", "putrequest"})
//    void deletebooking()
//    {
//        given()
//                .contentType("application/json")
//                .cookie("token", token)
//
//                .when()
//                .delete("https://restful-booker.herokuapp.com/booking/"+bookingnumber)
//
//                .then()
//                .log().all()
//                .statusCode(200);
//
//
//
//
//
//    }
//
//// Dummay API"s for practise
//
////    {
////        "company": "ABC Technologies",
////            "location": "Bangalore",
////
////            "employees": [
////        {
////            "id": 101,
////                "name": "Malli",
////                "role": "QA Engineer"
////        },
////        {
////            "id": 102,
////                "name": "Rahul",
////                "role": "Developer"
////        }
////  ]
////    }
//
////    How to validate response data
//
////    1st approach, validation in then section
//
//    @Test
//    void dummy1()
//    {
//        given()
//
//                .when()
//                .get("dummay url")
//
//                .then()
//                .statusCode(200)
//                .body("employees[0].role", equalTo("QA Enginee"))
//                .body("employees[1].name", equalTo("Rahul"))
//                .header("contentytype", "application/json");
//
//    }
//
//    @Test
//    void usinghashmapss()
//    {
//        HashMap<String, Object> data = new HashMap<>();
//        data.put("firstname", "Malli");
//        data.put("lastname", "BS");
//        data.put("totalprice", 1234);
//        data.put("depositpaid", true);
//
//        HashMap<String, String> bookingdatess = new HashMap<>();
//        bookingdatess.put("checkin", "2018-01-01");
//        bookingdatess.put("checkout", "2019-01-01");
//
//        data.put("bookingdates", bookingdatess);
//
//        data.put("additionalneeds", "Breakfast");
//
//
//        given()
//                .contentType("application/json")
//                .body(data)
//
//                .when()
//                .post("https://restful-booker.herokuapp.com/booking")
//
//
//                .then()
//                .statusCode(200)
//                .log().all()
//                .header("Content-Type", "application/json; charset=utf-8")
//                .body("booking.firstname", equalTo("Malli"))
//                .body("employees[0].name", equalTo("Malli"))
//                .body("company", equalTo("ABC Technologies"));
//
//    }
//
//    @Test
//    void postrequestdatausingorgjson()
//    {
//// Post request body creation using json object
//        JSONObject data = new JSONObject();
//
//        data.put("Name", "Scott");
//        data.put("Location", "France");
//        data.put("phone", 12345);
//
//        String coursesarr[] = {"c", "C++"};
//
//        data.put("courses", coursesarr);
//
//        given()
//                .contentType("application/json")
//                .body(data.toString())
//
//                .when()
//                .post("URL here")
//
//
//                .then()
//                .statusCode(200)
//                .log().all() // print everything from the response, inclduing, repsosne body, cookie info, header info, status code
//                .log().headers() // print only headers info
//                .log().cookies() // print only cookies info
//                .log().body(); // print all the response body
//
//
//    }
//
////
//    @Test
//    void requestbodyusingPojoclass()
//    {
////        Post request body using POJO class
//
////        1st we need to create a pojo class, i have created a seperate class for POJO
//
//        Bookingdatespojoclass data = new Bookingdatespojoclass();
//        data.setName("Malli");
//        data.setLocation("Banglore");
//        data.setPhone("953567");
//
////        data.setCourses({"c", "C++"}); here we cannot directly send the array
////        1st we need to create the array then send it
//
//        String coursesarry[] = {"C", "C++"};
//
//        data.setCourses(coursesarry);
//
//        given()
//                .contentType("appilcation/json")
//                .body(data)
//
//                .when()
//                .post("url here")
//
//                .then()
//                .statusCode(200);
//
//    }
//
//    @Test
//    void requestbodyusingexternaljsonlibrary() throws FileNotFoundException {
//
////        to get data fron the externalfile, 1st we need to open the file
//
//        File f = new File(".//body.json");
//
////        To read the data inside the file
//
//        FileReader fr = new FileReader(f);
//
////
//        JSONTokener jt = new JSONTokener(fr);
//
////
//
//      JSONObject data = new JSONObject(jt);
//
//      given()
//              .contentType("application/json")
//              .body(data.toString())
//
//
//              .when()
//              .post("url here")
//
//              .then()
//              .statusCode(200);
//    }
//
//    @Test
//    void pathandqueryparams()
////        url https://reqres.in/api/users/2?delay=3
//
//    {
//        given()
//                .pathParams("id", 2)
//                .queryParam("delay", 3)
//                .contentType("application/json")
//
//                .when()
//                .get("https://reqres.in/api/users/{id}")
//
//                .then()
//                .statusCode(200)
//
////                to verify cookies, cookies value always keeps changing, so we really cannot validate the cookie
//                .cookie("AEM", "32432423");
//
//    }
//
////    to capture cookies and headers info
//
//    @Test(priority = 1)
//    void cookieandheaders()
//    {
//
////        to capture all the cookies information, we need to capture
////        the response in response variable
//
//       Response rs =  given()
//
//                .when()
//                .get("https://www.google.com/");
//
////       to capture single cookie information
//
//       String cookie1=rs.getCookie("AEC").toString();
//        System.out.println(cookie1);
//
////        by default rs.getcookie("AEC") returns cookie value in string formate
////        so no need to write to string here
//
//        String cookie2=rs.getCookie("NID");
//        System.out.println(cookie2);
//
////        to capture all the cookie information
//
//        Map<String, String> allcookies=rs.getCookies();
//
//        for (String k : allcookies.keySet())
//        {
//
//            System.out.println(rs.getCookie(k));
//
//        }
//
//        //    to capture single header information
//
//       String header1 =  rs.getHeader("content-type");
//
////        to capture all the header information
//
//        Headers hr=rs.getHeaders();
//
//        for (Header h : hr)
//        {
//
//            System.out.println(h.getName() + " " + h.getValue());
//        }
//
//    }
//
//}
//
//
//
//
//
//
