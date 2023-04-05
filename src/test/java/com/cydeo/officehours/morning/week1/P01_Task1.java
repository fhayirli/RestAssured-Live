package com.cydeo.officehours.morning.week1;

import com.cydeo.utility.HRTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P01_Task1 extends HRTestBase {

    /**
     * Send request to HR API URL  and save the response
     * Path Param job_id is IT_PROG
     * GET /jobs/{job_id}
     * Store the response in Response Object that comes from get Request
     * Verify followings
     *     - Print response
     *     - Status Code is 200
     *     - Content-Type is application/json
     *     - job_id is IT_PROG
     *     - job_title is Programmer
     *     - Get me first rel information
     *     - Get me 2,3 rel information
     * 	   - Get me all rel information
     */
    @Test
    public void getSingleJob() {

        Response response = RestAssured.given().log().uri()
                .and()
                .pathParam("id", "IT_PROG")
                .when().get("/jobs/{id}").prettyPeek();


        //    * Verify followings
        //     *     - Status Code is 200
        Assertions.assertEquals(HttpStatus.SC_OK,response.statusCode());

        //     *     - Content-Type is application/json
        Assertions.assertEquals(ContentType.JSON.toString(),response.contentType());

        // CREATE JSON PATH OBJECT
        JsonPath jp = response.jsonPath();

        //     *     - job_id is IT_PROG
        Assertions.assertEquals("IT_PROG",jp.getString("job_id"));

        //     *     - job_title is Programmer
        Assertions.assertEquals("Programmer",jp.getString("job_title"));

        //     *     - Get me first rel information
        System.out.println("jp.getString(\"links[0].rel\") = " + jp.getString("links[0].rel"));

        //     *     - Get me 2,3 rel information
        System.out.println("jp.getString(\"links[1,2].rel\") = " + jp.getString("links[1,2].rel"));

        //     * 	 - Get me all rel information
        List<String> allRels = jp.getList("links.rel");

        System.out.println("allRels = " + allRels);


    }
}
