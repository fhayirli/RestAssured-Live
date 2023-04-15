package com.cydeo.week3;

import com.cydeo.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class P02_JSONSchemaValidation extends SpartanTestBase {


    @Test
    public void allSpartansSchemaValidation() {

        given().log().uri()
                .accept(ContentType.JSON).
        when().get("/spartans").prettyPeek().
        then().log().ifValidationFails()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schema/AllSpartansSchema.json"));

    }

    @Test
    public void allSpartansSchemaValidation2() {

        given().log().uri()
                .accept(ContentType.JSON).
                when().get("/spartans").prettyPeek().
                then().log().ifValidationFails()
                .statusCode(200)
                .body(matchesJsonSchema(new File("src/test/resources/schema/AllSpartansSchema.json")));

    }



}
