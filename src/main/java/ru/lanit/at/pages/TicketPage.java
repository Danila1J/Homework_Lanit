package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "отдельного тикета")
public class TicketPage extends WebPage {
    @Name("кнопка Edit")
    private SelenideElement editButton = $x("//span//button[contains(text(),'Edit')]");
    @Name("поле Attachments")
    private SelenideElement attachmentsField = $x("//tbody/tr/td/ul");
}
