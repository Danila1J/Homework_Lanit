package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "редактирования тикета")
public class EditPage extends WebPage {
    @Name("кнопка Выберите файл")
    private SelenideElement attachFileButton = $x("//*[@id='id_attachment']");
    @Name("кнопка Save Changes")
    private SelenideElement saveChangesButton=$x("//input[@value='Save Changes']");

}
