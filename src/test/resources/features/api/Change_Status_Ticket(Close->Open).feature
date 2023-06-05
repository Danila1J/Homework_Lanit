#language:ru
@test

Функционал: Негативная проверка: перевода статуса тикета из "Закрыт" в "Открыт"

  Предыстория: Получения токена авторизации
    * создать запрос
      | method | path       | body       |
      | POST   | /api/login | login.json |
    * добавить header
      | Content-Type | application/json |
    * отправить запрос
    * статус код 200
    * извлечь данные
      | token | $.token |

  Сценарий: Изменение тикета с помощью HelpDesk API, путем отправки PATCH запроса,
  c указанием поля status = 4 для тикета id=39
    * создать запрос
      | method | path            | body                    |
      | PATCH  | /api/tickets/39 | changeStatusTicket.json |
    * добавить header
      | Content-Type  | application/json |
      | Authorization | Token ${token}   |
    * отправить запрос
    * статус код 422
