## Тестовое задание 
Приложение REST API вычисляющее частоту встречи символов по заданной строке. 
Результат отсортирован по убыванию количества вхождений символа.
##  Пример GET запроса
```
http://localhost:8080/api?string=ffbbcddddd
```
##  Пример JSON ответа
1. Если строка не пустая, то вернется статус 200 OK
```
{
    "c": 1,
    "b": 2,
    "f": 2,
    "d": 5
}
```
2. Если строка пустая, то вернеться статус 400 Bad Request
```
Ошибка! На вход была подана пустая строка!
```
##  Тестирование
Приложение покрыто тестами с помощью библиотеки JUnit
##  Используемые технологии
Java 17, Spring Boot 3.1.4, JUnit 5, Lombok, Maven.