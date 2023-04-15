package com.cydeo.week3;

import com.cydeo.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class P02_JSONSchemaValidation extends SpartanTestBase {


    @Test
    public void allSpartansSchemaValidation() {

        given().log().uri()
                .accept(ContentType.JSON).
        when().get("/spartans").prettyPeek().
        then().log().ifValidationFails()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/AllSpartansSchema.json"));

    }
}
