package pages;

import io.qameta.allure.Step;
import models.Dictionaries;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Страница отдельного тикета (авторизированный пользователь)
 */
public class TicketPage extends HelpdeskBasePage {

    /* Верстка страницы может измениться, поэтому для таблиц вместо индексов строк и столбцов лучше использовать
       более универсальные локаторы, например поиск по тексту + parent, following-sibling и другие.

       Текст тоже может измениться, но в этом случае элемент не будет найден и тест упадет,
       а ошибку можно будет легко локализовать и исправить.
       В случае изменений ячеек таблицы, локатор будет продолжать работать, но будет указывать на другой элемент,
       поведение теста при этом изменится непредсказуемым образом и ошибку будет сложно найти. */
    private WebElement dueDate = driver.findElement(By.xpath("//th[text()='Due Date']/following-sibling::td[1]"));
    private WebElement title = driver.findElement(By.xpath("//span/ancestor::th/h3[starts-with(text(),'DH')]"));
    private WebElement queue = driver.findElement(By.xpath("//span/ancestor::*[contains(.,'Queue')][self::th][1]"));
    private WebElement email = driver.findElement(By.xpath("//th[text()='Submitter E-Mail']/following-sibling::td[1]"));
    private WebElement priority = driver.findElement(By.xpath("//tr/th[text()='Priority']/following-sibling::td[1]"));
    private WebElement description = driver.findElement(By.xpath("//tr/td/h4[text()='Description']/following-sibling::p"));

    @Step("Проверить значение полей на странице тикета")
    public void checkTicket(Ticket ticket) {
        Assert.assertEquals(getTitleTicket(title.getText()),ticket.getTitle());
        Assert.assertEquals(getDueDate(dueDate.getText()),ticket.getDue_date());
        Assert.assertEquals(getQueue(queue.getText()),Dictionaries.getQueue(ticket.getQueue()));
        Assert.assertEquals(email.getText(),ticket.getSubmitter_email());
        Assert.assertEquals(priority.getText(), Dictionaries.getPriority(ticket.getPriority()));
        Assert.assertEquals(description.getText(),ticket.getDescription());
    }

    private String getTitleTicket(String titleNotEdited){
        Pattern pattern = Pattern.compile("\\.\\s(.*?)\\s\\[");
        Matcher matcher = pattern.matcher(titleNotEdited);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return titleNotEdited;
    }

    private String getDueDate(String dateNotEdited){
        String pattern = "(\\w+) (\\d+), (\\d+), (\\d+):(\\d+) (\\w+)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(dateNotEdited);
        if (matcher.find()) {
            int month = Month.valueOf(matcher.group(1).toUpperCase()).getValue();
            int day = Integer.parseInt(matcher.group(2));
            int year = Integer.parseInt(matcher.group(3));
            int hour = Integer.parseInt(matcher.group(4));
            int minute = Integer.parseInt(matcher.group(5));
            LocalDateTime dateTime = LocalDateTime.of(year,month, day, hour, minute);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
            return  dateTime.format(formatter);
        }
        return null;
    }

    private String getQueue(String queueNotEdited){
        int colonIndex = queueNotEdited.indexOf(":");
        int newlineIndex = queueNotEdited.indexOf("\n", colonIndex);
        return queueNotEdited.substring(colonIndex + 2, newlineIndex);
    }
}
