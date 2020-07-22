package db.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class UserResourceTest {

    @Test
    public void testPeopleEndpoint() {
        given()
          .when().get("/api/users/people")
          .then()
             .statusCode(200);
    }

    @Test
    public void testFindByNameEndpoint() {
        given()
                .when().get("/api/users/people/by-name/name2")
                .then()
                .statusCode(200);
    }

    @Test
    public void testFindPersonByIdEndpoint() {
        given()
                .when().get("/api/users/person/1")
                .then()
                .statusCode(200);
    }
}
