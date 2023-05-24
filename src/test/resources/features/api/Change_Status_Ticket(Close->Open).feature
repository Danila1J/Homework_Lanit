#language:ru
@test

Функционал: Негативная проверка: перевода статуса тикета из "Закрыт" в "Открыт"

  Сценарий: Изменение тикета с помощью HelpDesk API, путем отправки PATCH запроса,
  c указанием поля status = 4 для тикета id=39
    * создать запрос
      | method | path            | body                    |
      | PATCH  | /api/tickets/39 | changeStatusTicket.json |
    * добавить header
      | Content-Type  | application/json                               |
      | Authorization | Token 2bbc06c4d2625c2313e49ce3d7c673ab4c40708f |
    * отправить запрос
    * статус код 422
