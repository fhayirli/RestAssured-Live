package com.cydeo.officehours.morning.week2;

import com.cydeo.utility.LibraryTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class P01_LibraryLoginTest extends LibraryTestBase {

    @Test
    public void loginTest() {


        JsonPath jp = given().log().uri()
                .contentType(ContentType.URLENC) // same with application/x-www-form-urlencoded
                .formParam("email", "librarian10@library")
                .formParam("password", "libraryUser").
                // This is how to send body with URLENCODED format
                        when().post("/login").prettyPeek().
                then().statusCode(200)
                .extract().jsonPath();


        // How to extract token information
        String token = jp.getString("token");
        System.out.println(token);


        // Send get request to retrieve dashboard_stats


    }
}
