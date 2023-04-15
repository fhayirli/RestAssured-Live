package com.cydeo.week3;

import com.cydeo.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

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

    @Test
    public void postSpartansSchemaValidation() {

        Map<String,Object> spartan=new LinkedHashMap<>();
        spartan.put("name","JSON SCHEMA");
        spartan.put("gender","Male");
        spartan.put("phone",1234567890l);

        System.out.println(spartan);


        given().log().uri()
                .accept(ContentType.JSON)      // API I am expecting data in JSON format
                .contentType(ContentType.JSON) // API I am sending data in JSON format
                .body(spartan). // Serialization happens with BODY method
        when().post("/spartans").prettyPeek().
        then().statusCode(201)
                .body(matchesJsonSchemaInClasspath("schema/SpartanPostSchema.json"));





    }







}
