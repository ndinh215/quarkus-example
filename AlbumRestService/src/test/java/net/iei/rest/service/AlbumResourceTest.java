package net.iei.rest.service;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AlbumResourceTest {

    @Test
    public void testGetAlbumsEndpoint() {
        given()
          .when().get("/rest/sampleservice/albums")
          .then()
             .statusCode(200);
    }

    @Test
    public void testGetAlbumEndpoint() {
        given()
                .when().get("/rest/sampleservice/album/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetJSONAlbumsEndpoint() {
        given()
                .when().get("/rest/sampleservice/json/albums")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetJSONAlbumEndpoint() {
        given()
                .when().get("/rest/sampleservice/json/album/1")
                .then()
                .statusCode(200);
    }
}
