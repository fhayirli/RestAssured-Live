package com.cydeo.week2;

import com.cydeo.utility.FruitAPITestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

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

        Map<String,Object> requestMap=new LinkedHashMap<>();
        requestMap.put("firstname","TJ");
        requestMap.put("lastname","Olson");

        JsonPath jsonPath = given().log().uri().accept(ContentType.JSON)   // I need data in JSON FORMAT
                .contentType(ContentType.JSON)  // HEY API I am sending data in JSON FORMAT
                .body(requestMap).
                when().post("/shop/customers/").prettyPeek().
                then().statusCode(201)
                .extract().jsonPath();


        // API RESPONSE
        String firstname = jsonPath.getString("firstname");
        System.out.println(firstname);
        String lastname = jsonPath.getString("lastname");
        System.out.println(lastname);


        // MAP --> requestMap

        Assertions.assertEquals(requestMap.get("firstname"),firstname);
        Assertions.assertEquals(requestMap.get("lastname"),lastname);

        // VERIFY DATA BY USING CUSTOMER ID WITH GET REQUEST

        // retrieve customer url
        // send request to customer url
        String customerUrl = jsonPath.getString("customer_url");
        System.out.println("-------- GET REQUEST FOR CREATED CUSTOMER -------");
        get(customerUrl).prettyPeek();

        // STORE DATA IN JSON PATH AND DO VERIFICATION AGAINST DATA THAT WE POST

        // DATA FROM GET VS REQUEST BODY


    }
}
