package com.cydeo.week1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class P01_SimpleGetRequest {

    /**
     * 1. Send request to HR url and save the response
     * 2. GET /regions
     * 3. Store the response in Response Object that comes from GET Request
     * 4. Print out followings
     *     - Headers
     *     - Content-Type
     *     - Status Code
     *     - Response
     *     - Date
     *     - Verify response body has "Europe"
     *     - Verify response has Date
     */

    /**
     * CTRL+ENTER --> MAC
     * ALT+ENTER --> WIN
     *
     * to create Test Method
     */
    @Test
    public void simpleGETRequest() {


        Response response=RestAssured.get("http://54.144.20.60:1000/ords/hr/regions");

        //     *     - Response
        response.prettyPrint();


        //  Print out followings
        //     *     - Headers
        System.out.println("response.getHeaders() = " + response.getHeaders());
        System.out.println("response.headers() = " + response.headers());

        //     *     - Content-Type
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.getContentType() = " + response.getContentType());

        //     *     - Status Code
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        //     *     - Date
        System.out.println("response.header(\"Date\") = " + response.header("Date"));


        //     *     - Verify response has Date
        System.out.println("response.getHeaders().hasHeaderWithName(\"Date\") = " + response.getHeaders().hasHeaderWithName("Date"));

        //     *     - Verify response body has "Europe"
        System.out.println("response.asString().contains(\"Europe\") = " + response.asString().contains("Europe"));



    }


    /**
     * 1. Send request to HR url and save the response
     * 2. GET /employees/100
     * 3. Store the response in Response Object that comes from get Request
     * 4. Print out followings
     *     - First Name
     *     - Last Name
     *     - Verify status code is 200
     *     - Verify First Name is "Steven"
     *     - Verify content-Type is application/json
     */






}
