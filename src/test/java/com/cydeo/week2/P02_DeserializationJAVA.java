package com.cydeo.week2;

import com.cydeo.utility.CydeoTrainingTestBase;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
public class P02_DeserializationJAVA extends CydeoTrainingTestBase {

    /**
     * Create a test called getTeachers
     * 1. Send request to GET /teacher/all
     * 2. log uri to see
     * 3. Get all Json as a map and print out screen all the things with the help of  map
     * System.out.println("====== GET FIRST TEACHER INFO AS MAP  ======");
     * System.out.println("====== GET FIRST TEACHER NAME  ======");
     * System.out.println("====== GET ALL TEACHER INFO  AS LIST OF MAP======");
     * System.out.println("====== FIRST TEACHER INFO======");
     * System.out.println("====== FIRST TEACHER NAME ======");
     * System.out.println("====== LAST TEACHER NAME  ======");
     */

    @Test
    public void deserializeJAVA() {


        Response response = given().log().uri().
                when().get("/teacher/all").prettyPeek().
                then().statusCode(200)
                .extract().response();


        // response.as("teachers[0]", Map.class);
        // response.as method doest not allow to retrieve partil part of JSON by providing GPATH
        // That is why we are not eligible to do it
        //     * System.out.println("====== GET FIRST TEACHER INFO AS MAP  ======");
        //     * System.out.println("====== GET FIRST TEACHER NAME  ======");


        Map<String,Object> allTeachers = response.as(Map.class);
        System.out.println("allTeachers = " + allTeachers);
        //     * System.out.println("====== GET ALL TEACHER INFO  AS LIST OF MAP======");
        //     * System.out.println("====== FIRST TEACHER INFO======");
        //     * System.out.println("====== FIRST TEACHER NAME ======");
        //     * System.out.println("====== LAST TEACHER NAME  ======");



    }
}
