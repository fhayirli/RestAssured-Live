package com.cydeo.utility;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


import static io.restassured.RestAssured.*;
public abstract class HRTestBase {

    @BeforeAll
    public static void init(){

        baseURI="http://54.144.20.60:1000";
        basePath="/ords/hr";

    }

    @AfterAll
    public static void destroy(){

        reset();

    }
}
