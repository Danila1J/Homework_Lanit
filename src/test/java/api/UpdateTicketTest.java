package api;

import model.Status;
import model.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Обновление тикета
 */
public class UpdateTicketTest extends BaseTest {

    @Test
    public void updateTicketTest() {
        Ticket newTicketClosed = createTicket(buildNewTicket(Status.CLOSED, 2));
        newTicketClosed.setStatus(Status.OPEN.getCode());
        updateTicketNegative(newTicketClosed);
    }

    private void updateTicketNegative(Ticket ticket) {
        given()
                .header("Authorization", "Token " + System.getProperty("api.key"))
                .body(ticket)
                .pathParam("id", ticket.getId())
                .when()
                .patch("/api/tickets/{id}")
                .then()
                .statusCode(422);
    }
}
