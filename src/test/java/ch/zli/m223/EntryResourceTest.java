package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
@QuarkusTest
public class EntryResourceTest {
/* 
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
    */
}