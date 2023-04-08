package com.cydeo.week2;
import com.cydeo.pojo.MRData;
import com.cydeo.pojo.Status;
import com.cydeo.utility.FormulaAPITestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
public class P03_DeserializationPOJO extends FormulaAPITestBase {

    /*
        - ERGAST API
        - Given accept type is json
        - When user send request /status.json
        - Then verify status code is 200
        - And content type is application/json; charset=utf-8
        - And total is 137
        - And limit is 30
        - And each status has statusId
     */

    @Test
    public void POJO() {

        JsonPath jsonPath = given().log().uri().
                when().get("/status.json").prettyPeek().
                then().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract().jsonPath();

        MRData mrData = jsonPath.getObject("MRData", MRData.class);
        System.out.println(mrData);

        //        - And total is 137
        Assertions.assertEquals("137",mrData.getTotal());

        //        - And limit is 30
        Assertions.assertEquals("30",mrData.getLimit());

        //        - And each status has statusId


        System.out.println("------- STATUS TABLE -------");
        System.out.println(mrData.getStatusTable());

        System.out.println("------- STATUS LIST -------");
        List<Status> allStatus = mrData.getStatusTable().getStatus();
        for (Status status : allStatus) {
            System.out.println(status);
        }

        System.out.println("------- FIRST STATUS DETAILS  -------");

        // mrData.getStatusTable().getStatus().get(0) ---> it will give first status as OBJECT
        Status firstStatus = allStatus.get(0);

        System.out.println(firstStatus.getStatusId());
        System.out.println(firstStatus.getCount());
        System.out.println(firstStatus.getStatus());


    }
}
