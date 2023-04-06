package com.cydeo.officehours.evening;

import com.cydeo.utility.BookstoreTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// for not to write unnecessary words in the test
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class Task02 extends BookstoreTestBase {
// Task: verify we have 8 books in the collection
    @Test
    public void BooksTest01(){

        Response response = given().log().uri()
                .accept(ContentType.JSON)
                .get("/BookStore/v1/Books");

        int expectedAmount = 8;
        List<Object> books = response.path("books");
        int actualAmount = books.size();

        assertEquals(expectedAmount,actualAmount);

        JsonPath jsonPath = response.jsonPath();
        // useful methods to read response object and store the data into JAVA data types
        actualAmount = jsonPath.getList("books").size();
        assertEquals(expectedAmount,actualAmount);

    }

    @Test
    public void BooksTest02(){
        Response response = given().log().uri()
                .accept(ContentType.JSON)
                .queryParam("ISBN","9781449325862")
                .get("/BookStore/v1/Book");
        response.prettyPrint();

        // How we are using jsonpath object: first we need to change response object to jsonpath object
        JsonPath jsonPath = response.jsonPath();
        String expectedISBN = "9781449325862";
        String actualISBN = jsonPath.getString("isbn");
        assertEquals(expectedISBN,actualISBN);

    }
}
