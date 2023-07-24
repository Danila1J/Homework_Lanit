#language:ru
@test

Функционал: Сохранение поискового запроса

  Сценарий: Сохранение поискового запроса

    * открыть браузер
    * открыть url "https://at-sandbox.workbench.lanit.ru/"
    * переход на страницу "Helpdesk"

    * кликнуть на элемент "кнопка Log In"
    * переход на страницу "Авторизация"
    * ввести в поле "Username" значение "admin"
    * ввести в поле "Password" значение "adminat"
    * кликнуть на элемент "кнопка Login"

    * переход на страницу "просмотр тикетов"
    * на странице присутствует подстрока "Query Selection"
    * выбрать в раскрывающемся списке "Sorting" c значением "Priority"

    * кликнуть на элемент "кнопка Save Query(для раскрытия блока)"
    * ввести в поле "Query name" значение "Название поискового запроса2"
    * кликнуть на элемент "кнопка Save Query(для сохранения)"

    * переход на страницу "Helpdesk"
    * кликнуть на элемент "Saved Queries"
    * проверить что элемент "список Saved Queries" содержит текст "Название поискового запроса2"