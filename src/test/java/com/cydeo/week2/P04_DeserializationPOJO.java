package com.cydeo.week2;

import com.cydeo.pojo.CustomerData;
import com.cydeo.utility.FruitAPITestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
public class P04_DeserializationPOJO extends FruitAPITestBase {

    /**
     * Send request to FruitAPI url and save the response
     * Accept application/json
     * GET /shop/customers/
     * Store the response in Response Object that comes from get Request
     * Print out followings
     *     - Print response
     *     - Content-Type is application/json; charset=utf-8
     *     - Status Code is 200
     *     - Retrieve data as POJO Class and print out into screen
     */
    @Test
    public void deserialization() {

        JsonPath jp = given().log().uri()
                .accept(ContentType.JSON).
                when().get("/shop/customers/").prettyPeek().
                then().statusCode(200)
                .extract().jsonPath();

        CustomerData customerData = jp.getObject("", CustomerData.class);

        System.out.println(customerData);

        System.out.println("----- PRINT COUNT ----");

        System.out.println("----- PRINT LIMIT ----");

        System.out.println("----- PRINT NEXTURL ----");
        String nextUrl = customerData.getMeta().getNextUrl();


        while(nextUrl!=null){

             jp = get(nextUrl).prettyPeek()
                    .then().statusCode(200)
                    .extract().jsonPath();



             // To update each time current response nextURL infromation
             nextUrl = jp.getString("meta.next_url");

        }


    }
}
