package com.cydeo.week1;

import com.cydeo.utility.FruitAPITestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class P03_PathParam extends FruitAPITestBase {

    /**
     *1- Given accept type is Json
     *2- Path Parameters value is
     *     - id —> Fruits
     *3- When user sends GET request to /categories/{id}
     *4- Verify followings
     *     - Status code should be 200
     *     - Content Type is application/json; charset=utf-8
     *     - Print response
     *     - Name is "Fruits"
     *
     */

    @Test
    public void getSingleCategory() {

        Response response = given().accept(ContentType.JSON)
                .when().get("/shop/categories/Fruits");

        response.prettyPrint();




    }
}
