package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name (value = "Helpdesk")
public class MainPage extends WebPage {
    @Name("кнопка новый тикет")
    private SelenideElement newTicketButton = $x("//span[contains(text(),'New Ticket')]");
    @Name("кнопка Log In")
    private SelenideElement logInButton = $x("//*[@id='userDropdown']");
    @Name("поиска")
    private SelenideElement inputSearch = $x("//input[@id='search_query']");
    @Name("кнопка Go")
    private SelenideElement goButton = $x("//nav//button[@type='submit']");
    @Name("Saved Queries")
    private SelenideElement dropdownMenu=$x("//*[@id='ticketsDropdown']");
    @Name("список Saved Queries")
    private SelenideElement dropdownMenuList=$x("//a[@id='ticketsDropdown']/following-sibling::div");


}

