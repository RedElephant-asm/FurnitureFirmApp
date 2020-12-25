# Furniture firm
## Simple spring boot app

![markdown logo](./mdfiles/images/logos/spring-boot-logo.png)

Веб приложение предполагает взаимодействие с базой
данных, содержащей информацию о некой мебельной
фирме(активные пользователи, материалы, фурнитура).
Приложение реализует CRUD операции(create, read,
update, delete).

## Backend-часть проекта
![markdown logo](./mdfiles/images/logos/hibernate-logo.jpeg)
Для взаимодействия с базой данных применяется `Hibernate API`.

## Frontend-часть проекта
![markdown logo](./mdfiles/images/logos/thymeleaf-logo.png)
Чётко выраженная frontend-часть у проекта отсутствует. Вместо нее
применяется шаблонизатор `Thymeleaf`.

## Разграничение доступа
Для ограничения доступа неавторизованных пользователей, а также
разграничения прав авторизованны пользователей применяется Spring Security.

## Ajax
Ajax запросы у приложения отсутствуют.

## Запуск проекта
![markdown logo](./mdfiles/images/logos/maven-logo.png)
Так как у проекта есть POM, он может быть запущен с помощью
Maven из командной строки
```
...\FurnitureFirmApp>mvn spring-boot:run
```
Также проект может быть запущен с помощью IntellijIDEA прямо
из класса Spring boot приложения:
```
@SpringBootApplication
public class FurnitureFirmSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(FurnitureFirmSpringBootApplication.class, args);
    }
}
```
После старта проекта, обратиться к нему можно по адресу
`http://localhost:8080`