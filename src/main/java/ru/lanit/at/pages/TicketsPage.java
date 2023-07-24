package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "просмотр тикетов")
public class TicketsPage extends WebPage {
    @Name("Sorting")
    private SelenideElement dropdownListSorting = $x("//*[@id='id_sortx']");
    @Name("кнопка Save Query(для раскрытия блока)")
    private SelenideElement saveQueryButton = $x("//*[@id='headingTwo']/h5/button");
    @Name("Query name")
    private SelenideElement queryNameField = $x("//*[@id='id_title']");
    @Name("кнопка Save Query(для сохранения)")
    private SelenideElement saveQueryButton1 = $x("//*[@type='submit' and @value='Save Query']");
}
