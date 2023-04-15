package com.cydeo.week3;

import com.cydeo.utility.FormulaAPITestBase;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
public class P01_FormulaXML extends FormulaAPITestBase {

      /*
    - Send GET Request /drivers
           // first Driver Given Name
           // all Drivers Given Name
           // print out first driver driverId attribute
           // print out all driver driverId attribute
           // Print out all driver given name if their nationality is Italian

     */

    @Test
    public void xmlPractice() {

        Response response = given().log().all().
                when().get("/drivers").
                then().log().ifValidationFails()
                .statusCode(200)
                .extract().response();

        // to work with XML
        XmlPath xmlPath = response.xmlPath();

        //              first Driver Given Name
        String firstGivenName = xmlPath.getString("MRData.DriverTable.Driver[0].GivenName");
        System.out.println("firstGivenName = " + firstGivenName);

        //           // all Drivers Given Name
        List<String> allGivenNames = xmlPath.getList("MRData.DriverTable.Driver.GivenName");
        System.out.println("allGivenNames = " + allGivenNames);

        //           // print out first driver driverId attribute
        String firstDriverID = xmlPath.getString("MRData.DriverTable.Driver[0].@driverId");
        System.out.println("firstDriverID = " + firstDriverID);

        //           // print out all driver driverId attribute
        List<String> allDriverIDs = xmlPath.getList("MRData.DriverTable.Driver.@driverId");
        System.out.println("allDriverIDs = " + allDriverIDs);

        //           // Print out all driver given name if their nationality is Italian

    }
}
