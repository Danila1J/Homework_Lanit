#language:ru
@test

Функционал: Создание тикета с высоким приоритетом

  Сценарий: Создание тикета с помощью HelpDesk API, c указанием поля priority = 2

    * создать запрос
      | method | path         | body              |
      | POST   | /api/tickets | createTicket.json |
    * добавить header
      | Content-Type | application/json |
    * отправить запрос
    * статус код 201
    * извлечь данные
      | title           | $.title           |
      | submitter_email | $.submitter_email |
      | status          | $.status          |
      | description     | $.description     |
      | priority        | $.priority        |
      | queue           | $.queue           |
    * сравнить значения
      | ${title}           | == | Новый тикет      |
      | ${submitter_email} | == | user@example.com |
      | ${status}          | == | 1                |
      | ${description}     | == | Описание         |
      | ${priority}        | == | 2                |
      | ${queue}           | == | 1                |