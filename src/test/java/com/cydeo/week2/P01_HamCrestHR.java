package com.cydeo.week2;

import com.cydeo.utility.HRTestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class P01_HamCrestHR extends HRTestBase {
      /*
       Given accept type is Json
       And parameters: q={"region_id":2}
       When users sends a GET request to "/countries"
       Then status code is 200
       And Content type is application/json
       And Date header is not null
       Verify
           - count is 5
           - hasMore is false
           - first country id is AR
           - country names have Canada
           - country names have Canada,Mexico
           - total country size is 5
           - each country has country_id
           - each country region_id is 2
      - Print country names


     */

    @Test
    public void hamcrestHR() {
    }
}
