# ShopConsoleApp

## Описание

**ShopConsoleApp** — это консольное приложение для управления интернет-магазином. Оно позволяет добавлять и управлять пользователями, товарами и заказами.

---

## Установка

Убедитесь, что у вас установлены **Java 21** и **Maven**.

1. Клонируйте репозиторий:

   ```bash
   git clone https://github.com/AlekseiYanin-QA/ShopConsoleApp_2.git
   cd ShopConsoleApp_2

2. Соберите проект:

   ```bash
   mvn clean install
   
3. Запустите приложение:

   ```bash
   java -jar target/ShopConsoleApp_2-1.0-SNAPSHOT.jar

## Использование

После запуска приложения вы увидите меню:

1. Добавить пользователя
2. Добавить товар
3. Добавить заказ
4. Выйти
   Введите ваш выбор:

## Логирование
Логи приложения записываются в файл logs/app.log и выводятся в консоль. 
Пример логов:
`
15:30:45.123 [main] INFO  com.shop.service.UserService - User added: User(id=1, name=Иван, email=ivan@example.com) `


## Тестирование

  ```bash
   mvn test  
   
Тесты покрывают основные сценарии работы сервисов и проверяют обработку исключений.

