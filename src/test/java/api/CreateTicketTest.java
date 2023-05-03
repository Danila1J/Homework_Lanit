package api;

import model.Status;
import model.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Создание и проверка тикета
 */
public class CreateTicketTest extends BaseTest {

    @Test
    public void createTicketTest() {
        Ticket newTicket = createTicket(buildNewTicket(Status.OPEN, 2));
        Ticket getTicket = getTicket(newTicket.getId());
        Assert.assertEquals(newTicket, getTicket);
    }

    protected Ticket getTicket(int id) {
        Ticket getTicket = given()
                .header("Authorization", "Token " + System.getProperty("api.key"))
                .pathParam("id", id)
                .when()
                .get("/api/tickets/{id}")
                .then()
                .statusCode(200)
                .extract().body()
                .as(Ticket.class);
        return getTicket;
    }
}
