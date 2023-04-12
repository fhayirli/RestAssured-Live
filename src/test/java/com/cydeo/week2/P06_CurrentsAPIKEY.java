package com.cydeo.week2;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
public class P06_CurrentsAPIKEY {
    String apiKey="a6v39P9aam1Q7YaB-TS5u34p_AdSejb5RJoke0lA8YQIV6Ac";
    // Put config.properties
    @Test
    public void apiKeyQP() {


        given().log().uri().accept(ContentType.JSON)
                .baseUri("https://api.currentsapi.services/v1")
                .queryParam("apiKey","a6v39P9aam1Q7YaB-TS5u34p_AdSejb5RJoke0lA8YQIV6Ac").
        when().get("/latest-news").prettyPeek();

    }

    @Test
    public void apiKeyAuthHeader() {

        given().log().uri().accept(ContentType.JSON)
                .baseUri("https://api.currentsapi.services/v1")
                .header("Authorization","a6v39P9aam1Q7YaB-TS5u34p_AdSejb5RJoke0lA8YQIV6Ac").
                when().get("/latest-news").prettyPeek();

    }
}
