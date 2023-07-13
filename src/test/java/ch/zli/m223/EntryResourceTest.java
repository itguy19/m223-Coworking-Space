package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import ch.zli.m223.model.Entry;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;

@QuarkusTest
public class EntryResourceTest {

    @Test
    public void createEntry() {
        Entry updatedEntry = new Entry();
        LocalDateTime now = LocalDateTime.now();
        updatedEntry.setCheckIn(now);
        updatedEntry.setCheckOut(now.plusSeconds(15));

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(updatedEntry)
          .when()
            .post("/entries")
          .then()
             .statusCode(200);
    }

    @Test
    public void editEntry() {
        Entry updatedEntry = new Entry();
        LocalDateTime now = LocalDateTime.now();
        updatedEntry.setCheckIn(now);
        updatedEntry.setCheckOut(now.plusSeconds(15));
        updatedEntry.setId(1L);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(updatedEntry)
          .when()
            .put("/entries")
          .then()
             .statusCode(204);
    }

    @Test
    public void deleteEntry() {
        given()
          .when()
            .delete("/entries/{id}", 1)
          .then()
             .statusCode(204);
    }
}