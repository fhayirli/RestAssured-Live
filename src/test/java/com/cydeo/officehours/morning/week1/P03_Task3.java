package com.cydeo.officehours.morning.week1;

import com.cydeo.utility.FruitAPITestBase;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class P03_Task3 extends FruitAPITestBase {


    /**
     * Send request to Spartan url and save the response
     * Accept application/json
     * GET /shop/categories
     * Store the response in Response Object that comes from get Request
     * Print out followings
     *     - Print response
     *     - Content-Type is application/json; charset=utf-8
     *     - Status Code is 200
     *     - Get me first category name
     *     - Get me first category_url
     *     - Get me 2nd,3rd category name
     *     - Get me last category name
     *     - Get me all category name
     */

    @Test
    public void responsePath() {
    }
}
