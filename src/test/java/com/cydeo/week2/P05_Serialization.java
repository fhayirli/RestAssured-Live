package com.cydeo.week2;

import com.cydeo.utility.FruitAPITestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
public class P05_Serialization extends FruitAPITestBase {

      /*
    Given accept header is application json
    And content type is application json
    And requestBody field and values are
        |firstname|lastname|
        |Mike     |Smith   |
    When I send POST request /shop/customers endpoint
    Then status code should be 201
    And response body should have posted customer information


     */

    @Test
   public  void POSTwithMAP() {
    }
}
