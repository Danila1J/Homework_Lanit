#language:ru
@test

Функционал: Редактирование созданного тикета (с прикреплением файла в созданный тикет)

  Сценарий: Редактирование созданного тикета c прикреплением файла attachFileExample.rtf

    * открыть браузер
    * открыть url "https://at-sandbox.workbench.lanit.ru/"
    * переход на страницу "Helpdesk"

    * кликнуть на элемент "кнопка Log In"
    * переход на страницу "Авторизация"
    * ввести в поле "Username" значение "admin"
    * ввести в поле "Password" значение "adminat"
    * кликнуть на элемент "кнопка Login"

    * переход на страницу "Helpdesk"
    * ввести в поле "поиска" значение "Some django-helpdesk Problem"
    * кликнуть на элемент "кнопка Go"

    * кликнуть на элемент содержащий текст "Some django-helpdesk Problem"

    * переход на страницу "отдельного тикета"
    * кликнуть на элемент "кнопка Edit"

    * переход на страницу "редактирования тикета"
    * на странице присутствует подстрока "Attach File"
    * кликнуть на элемент "кнопка Выберите файл"
    * добавить в поле "кнопка Выберите файл" файл "attachFileExample.rtf"
    * кликнуть на элемент "кнопка Save Changes"

    * переход на страницу "отдельного тикета"
    * проверить что элемент "поле Attachments" содержит текст "attachFileExample.rtf"