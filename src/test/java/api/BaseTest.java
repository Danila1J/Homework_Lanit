package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import model.AuthToken;
import model.Status;
import model.Ticket;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import static io.restassured.RestAssured.given;

/**
 * Абстрактный класс, содержащий общие для всех тестов методы
 */
public abstract class BaseTest {
    @BeforeClass
    public void prepare() {
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String baseUri = System.getProperty("base.uri");
        if (baseUri == null || baseUri.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"base.uri\"");
        }
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUri) // задаём базовый адрес каждого ресурса
                .setAccept(ContentType.JSON) // задаём заголовок accept
                .setContentType(ContentType.JSON) // задаём заголовок content-type
                .log(LogDetail.ALL) // дополнительная инструкция полного логгирования для RestAssured
                .build(); // после этой команды происходит формирование стандартной "шапки" запроса.
        //Здесь задаётся фильтр, позволяющий выводить содержание ответа,
        // также к нему можно задать условия в параметрах конструктора, которм должен удовлетворять ответ (например код ответа)
        RestAssured.filters(new ResponseLoggingFilter());
    }

    protected AuthToken login() {
        String username = System.getProperty("username");
        String password = System.getProperty("password");
        String token = given()
                .body(new AuthToken(username, password, ""))
                .when()
                .post("/api/login")
                .then()
                .statusCode(200)
                .extract().body()
                .asString();
        return new AuthToken(username, password, new JsonPath(token).get("token"));
    }


    protected Ticket buildNewTicket(Status status, int priority) {
        return new Ticket("Название_Тикета", status.getCode(), priority, 1);
    }

    protected Ticket createTicket(Ticket ticket) {
        return given()
                .body(ticket)
                .when()
                .post("/api/tickets")
                .then()
                .statusCode(201)
                .extract().body() // у полученного ответа мы можем взять тело
                .as(Ticket.class); // и распарсить его как объект Ticket
    }
}
