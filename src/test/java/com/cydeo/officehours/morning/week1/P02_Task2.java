package com.cydeo.officehours.morning.week1;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class P02_Task2 {

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
    }
}
