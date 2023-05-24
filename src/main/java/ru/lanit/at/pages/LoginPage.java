package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name (value = "Авторизация")
public class LoginPage extends WebPage {

    @Name("Username")
    private SelenideElement username = $x("//*[@id='username']");

    @Name("Password")
    private SelenideElement password = $x("//*[@id='password']");

    @Name("кнопка Login")
    private SelenideElement loginButton = $x("//*[@type='submit']");
}
