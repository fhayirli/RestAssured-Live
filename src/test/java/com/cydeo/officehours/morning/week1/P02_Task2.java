package com.cydeo.officehours.morning.week1;

import com.cydeo.utility.BookstoreTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class P02_Task2 extends BookstoreTestBase {

    /**
     * Task 2:
     * Verify response body info of the first book
     *     When User sends GET request to receive first book info
     *     Then Verify that we have correct info about first book which we selected
     *     Book Information for validation
     *       | key          | value                                                                     |
     *       | isbn         | 9781449337711                                                             |
     *       | title        | Designing Evolvable Web APIs with ASP.NET                                 |
     *       | subTitle     | Harnessing the Power of the Web                                           |
     *       | author       | Glenn Block et al.                                                       |
     *       | publish_date | 2020-06-04T09:12:43.000Z                                                  |
     *       | publisher    | O'Reilly Media                                                            |
     *       | pages        | 238                                                                       |
     *       | description  | Design and build Web APIs for a broad range of clients—including browsers and mobile devices—that can adapt to change over time. This practical, hands-on guide takes you through the theory and tools you need to build evolvable HTTP services with Microsoft|
     *       | website      | http://chimera.labs.oreilly.com/books/1234000001708/index.html            |
     */



    @Test
    public void getBook() {


        Response response = given().accept(ContentType.JSON).
                log().uri()
                .queryParam("ISBN", "9781449337711").
                when().get("BookStore/v1/Book").prettyPeek();

        // JSONPATH OBJECT
        JsonPath jp = response.jsonPath();

        // Status Code
        assertEquals(200,response.statusCode());

        // VERIFY FOLLOWINGS
        //     *     Book Information for validation


        //     *       | isbn         | 9781449337711
        assertEquals("9781449337711",jp.getString("isbn"));
        System.out.println(jp.getString("isbn"));

        //     *       | title        | Designing Evolvable Web APIs with ASP.NET
        assertEquals("Designing Evolvable Web APIs with ASP.NET",jp.getString("title"));

        //             | subTitle     | Harnessing the Power of the Web   |
        assertEquals("Harnessing the Power of the Web",jp.getString("subTitle"));


        // REST OF THEM SAME

    }


}
