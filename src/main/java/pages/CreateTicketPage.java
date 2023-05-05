package pages;

import io.qameta.allure.Step;
import models.Dictionaries;
import models.Ticket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

/**
 * Страница создания тикета
 */
public class CreateTicketPage extends HelpdeskBasePage {

    @FindBy(id = "id_queue")
    private WebElement queueSelect;
    @FindBy(id = "id_title")
    private WebElement inputProblem;
    @FindBy(xpath = "//textarea[@name='body']")
    private WebElement description;
    @FindBy(id = "id_priority")
    private WebElement prioritySelect;
    @FindBy(id = "id_due_date")
    private WebElement dueDate;
    @FindBy(css = "input[type=file]")
    private WebElement attachFileButton;
    @FindBy(id="id_submitter_email")
    private WebElement submitterEmail;
    @FindBy(css = "button[type=submit]")
    private WebElement submitTicketButton;

    public CreateTicketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public CreateTicketPage(){
    }

    @Step("Создать тикет")
    public CreateTicketPage createTicket(Ticket ticket) {
        setInputProblem(ticket.getTitle());
        setQueueSelect(ticket.getQueue());
        setDescription(ticket.getDescription());
        setPrioritySelect(ticket.getPriority());
        setDueDate(ticket.getDue_date());
        //setAttachFileButton(ticket.getFile());
        setSubmitterEmail(ticket.getSubmitter_email());
        clickOnSubmitButton();
        return this;
    }

    @Step("Ввести имя проблемы: {text}")
    public void setInputProblem(String text) {
        inputProblem.sendKeys(text);
    }

    @Step("Выбрать очередь: {queue}")
    public void setQueueSelect(int queue) {
        new Select(queueSelect).selectByVisibleText(Dictionaries.getQueue(queue));
    }

    @Step("Ввести описание: {text}")
    public void setDescription(String text) {
        description.sendKeys(text);
    }

    @Step("Выбрать приоритет: {priority}")
    public void setPrioritySelect(int priority) {
        new Select(prioritySelect).selectByVisibleText(Dictionaries.getPriority(priority));
    }

    @Step("Выбрать срок выполнения: {due_date}")
    public void setDueDate(String due_date) {
        this.dueDate.sendKeys(due_date);
    }

    @Step("Выбрать файл: {file}")
    public void setAttachFileButton(File file) {
        attachFileButton.sendKeys(file.getAbsolutePath());
    }

    @Step("Ввести email: {email}")
    public void setSubmitterEmail(String email) {
        submitterEmail.sendKeys(email);
    }


    @Step("Нажать на кнопку создания тикета")
    public void clickOnSubmitButton() {
        submitTicketButton.click();
    }
}
