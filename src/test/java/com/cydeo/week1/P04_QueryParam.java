package com.cydeo.week1;

import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class P04_QueryParam {

    /**
     *1- Given accept type is Json
     *2- Query Parameters values are
     *     - minprice —> 0
     *     - maxprice —> 0.1
     *3- When user sends GET request to /activity
     *4- Print out Followings
     *     - response
     *     - activity
     *     - type
     *     - participants
     * 5- Verify followings
     *     - Status code should be 200
     *     - price is lower than 0.1

     */

    @Test
    public void getActivity() {




    }
}