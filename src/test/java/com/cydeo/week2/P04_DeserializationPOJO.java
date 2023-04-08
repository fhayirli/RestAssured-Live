package com.cydeo.week2;

import com.cydeo.utility.FruitAPITestBase;
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
    }
}
