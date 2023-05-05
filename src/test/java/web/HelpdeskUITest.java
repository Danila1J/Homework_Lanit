package web;

import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;
    private Ticket ticket;

    @BeforeClass
    public void setup() throws IOException {
        loadProperties();
        setupDriver();
    }

    @Step("Загрузить конфигурацилнные файлы")
    private void loadProperties() throws IOException {
        // Читаем конфигурационные файлы в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
    }

    @Step("Создать экземпляр драйвера")
    private void setupDriver() {
        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Установить созданный драйвер для поиска в веб-страницах
        AbstractPage.setDriver(driver);
    }

    @Test
    public void createTicketTest() {
        driver.get(System.getProperty("site.url"));//Предусловие: открыта главная страница сайта
        MainPage mainPage = new MainPage();
        ticket = buildNewTicket();

        mainPage.mainMenu().clickOnNewTicketButton();//Шаг 1

        new CreateTicketPage(driver).createTicket(ticket);//Шаг 2
        ViewPage viewPage=new ViewPage();
        viewPage.checkTicket(ticket);
        viewPage.saveId(ticket);

        mainPage.mainMenu().clickOnLogInButton();//Шаг 3

        new LoginPage().login(System.getProperty("user"), System.getProperty("password"));//Шаг 4
        Assert.assertEquals(mainPage.mainMenu().loginedUser(),System.getProperty("user"));

        mainPage.mainMenu().searchTicket(ticket);//Шаг 5

        new TicketsPage().openTicket(ticket);//Шаг 6
        new TicketPage().checkTicket(ticket);

        close();
    }

    private Ticket buildNewTicket() {
        Ticket ticket = new Ticket();
        ticket.setTitle("Название тикета" + new Random().nextInt(1000000));
        ticket.setQueue(1);
        ticket.setDescription("Описание тикета");
        ticket.setPriority(2);
        ticket.setDue_date(LocalDateTime.now());
        //ticket.setFile(new File(System.getProperty("path.file")));
        ticket.setSubmitter_email("example@gmail.com");
        return ticket;
    }

    @AfterTest
    public void close() {
        if (driver != null) {
            // Закрываем все открытые окна браузера, завершаем работу браузера, освобождаем ресурсы
            driver.quit();
        }
    }
}
