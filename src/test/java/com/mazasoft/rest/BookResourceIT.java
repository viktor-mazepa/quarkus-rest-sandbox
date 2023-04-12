package com.mazasoft.rest;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
public class BookResourceIT {

    @Test
    public void shouldGetAllBooks() {
        given().header(ACCEPT, APPLICATION_JSON)
                .when().get("/api/books")
                .then()
                .statusCode(OK.getStatusCode())
                .body("size()", is(4));
    }

    @Test
    public void shouldGetABooks() {
        given().header(ACCEPT, APPLICATION_JSON).pathParams("id", 1)
                .when().get("/api/books/{id}")
                .then()
                .statusCode(OK.getStatusCode())
                .body("title", is("Understanding Quarkus"))
                .body("author", is("Antonio"))
                .body("id", is(1))
                .body("yearOfPublication", is(2020))
                .body("genre", is(getGenre()));
    }

    @Test
    public void shouldGetCountOfBooks() {
        given().header(ACCEPT, TEXT_PLAIN)
                .when().get("/api/books/count")
                .then()
                .statusCode(OK.getStatusCode())
                .body(is("4"));
    }

    protected String getGenre() {
        return "Software Technology";
    }
}
