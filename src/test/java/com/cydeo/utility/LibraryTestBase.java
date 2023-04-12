package com.cydeo.utility;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public abstract class LibraryTestBase {

    @BeforeAll
    public static void init(){

        baseURI="https://library2.cydeo.com/rest/v1";

    }

    @AfterAll
    public static void destroy(){

        reset();

    }
}
