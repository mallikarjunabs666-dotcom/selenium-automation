package restassured.interviewpractice;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonparsingWithMultipleValidations {

    @Test
    void multipleValidations()
    {
        JSONObject data = new JSONObject();
        data.put("Name", "Mallikarjuna");

       Response response =  given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("url here")

                .then()
                .extract().response();


        System.out.println(response.jsonPath().getString("status"));
        System.out.println(response.jsonPath().getString("message"));
        System.out.println(response.jsonPath().getString("employee.name"));

//Nested Object
//Print department ID.
//Print department name.

        JsonPath path = response.jsonPath();

        System.out.println(path.getInt("employee.department.deptId"));
        System.out.println(path.getString("employee.department.deptName"));

//        JSON Array
//Print all skills.
//Print the second skill.
//Print all project names.
//Print all project IDs.

        JSONObject resobj = new JSONObject(response.asString());

        for (int i = 0; i<resobj.getJSONObject("employee").getJSONArray("skills").length(); i++)
        {
            System.out.println(resobj.getJSONObject("employee").getJSONArray("skills").getString(i));
        }

//        //Print the second skill.

        for (int i = 0; i<resobj.getJSONObject("employee").getJSONArray("skills").length(); i++)
        {
            if (i==1)
            {
                System.out.println(resobj.getJSONObject("employee").getJSONArray("skills").getString(i));
                break;
            }
        }

//        Print all project names.

        for (int i = 0; i<resobj.getJSONObject("employee").getJSONArray("projects").length(); i++)
        {
            System.out.println(resobj.getJSONObject("employee").getJSONArray("projects").getJSONObject(i).getString("projectName"));
        }

//        Print every skill using a loop.
//Print every project ID and project name using a loop.
//Count the number of skills.
//Count the number of projects.

//        Print every project ID and project name using a loop.

        for (int i = 0; i<resobj.getJSONObject("employee").getJSONArray("projects").length(); i++)
        {
            System.out.println(resobj.getJSONObject("employee").getJSONArray("projects").getJSONObject(i).getInt("projectId"));
            System.out.println(resobj.getJSONObject("employee").getJSONArray("projects").getJSONObject(i).getString("projectName"));
        }

//        Count the number of skills.

        System.out.println("Number pf skills are " + resobj.getJSONObject("employee").getJSONArray("skills").length());

//        Count the number of projects.
        System.out.println("Number of projects are " + resobj.getJSONObject("employee").getJSONArray("projects").length());


//        Print only the project whose ID is 1002.

        for (int i = 0; i<resobj.getJSONObject("employee").getJSONArray("projects").length(); i++)
        {
           int projectid = resobj.getJSONObject("employee").getJSONArray("projects").getJSONObject(i).getInt("projectId");

           if (projectid==1002)
           {
               System.out.println(resobj.getJSONObject("employee").getJSONArray("projects").getJSONObject(i).getString("projectName"));
               break;
           }
        }

//        Check whether the employee is active.
        boolean status = resobj.getJSONObject("employee").getBoolean("active");

        if (status==true)
        {
            System.out.println("employee is active");
        }

//        Check whether the department is QA.

        String depaname = resobj.getJSONObject("employee").getJSONObject("department").getString("deptName");

        if (depaname.equals("QA"))
        {
            System.out.println("Yes department name is qa");
        }


    }
}
