Всем привет. 

Данный проект представляет собой попытку воссоздать рабочий интернет-магазин. Под работоспособностью понимается успешный обмен информацией между клиентом и сервером, 
в основе которого лежит принцип MVC(Model-View-Controller). Приложение выполнено в среде IntelliJ IDEA 2021 Ultimate и развернуто с помощью контейера сервлетов Apache Tomcat.
Что касается конфигурации проекта, то она выполнена с помощью аннотаций.

*Все рисунки, которые я прикладываю для описания работы программы расположены в папке aboutProj.
В роли модели выступает база данных, схема которой представлена на рисунке 1. Для обращения к таблицам используется Hibernate посредством спецификации JPA(Java Persistence API).
Контроллером выступает Java class, который отмечен специальной аннотацией @Controller. Данный класс опиывает различные маппинги (Get+Post) для реализации CRUD операций. 
Стоит отметить, что реализованы следующие операции: создания, чтения, обновления и удаления записей из БД. 
Представление (View) выполнено на основе страниц JSP+JSTL.

Остановлюсь более подробно на логике работы приложения.
1. Зайти в магазин можно с аккаунта обычного пользователя, либо с правами администратора. Авторизации и аутентификация очередного посетителя сайта выполнена
с помощью Spring Security (для этого в базе данных созданы 2 таблицы: authorities и users). Пример процедуры аутентификации приведен на рисунке 2. Пароль занесен 
в базу на основе bcrypt шифрования.
2. С аккаунта обычного пользователя можно просматривать каталог товаров (рисунок 3-4), добавлять понравившиеся товары в корзину (в любом количестве), а также
совершать покупку (рисунок 5). 
3. С аккаунта администратора дополнительно появляется возможность изменять существующий товар (рисунок 6-7), удалять товар из списка, а также добавлять новый (рисунок 8). 
Данные операции осуществляются по нажатию на кнопки, которые рядовому пользователю недоступны (рисунок 9).

Спасибо.

--------------------------------

Hello everyone.

This project is an attempt to recreate a working online store. Operability refers to the successful exchange of information between the client and the server,
which is based on the principle of MVC (Model-View-Controller). The application is executed in the IntelliJ IDEA 2021 Ultimate environment and deployed using the Apache Tomcat servlet container.
As for the project configuration, it is done using annotations.

*All the pictures that I attach to describe the work of the program are located in the aboutProj folder.
The database acts as a model, the scheme of which is shown in Figure 1. To access tables, Hibernate is used through the JPA specification (Java Persistence API).
The controller is the Java class, which is marked with a special annotation @Controller. This class describes various mappings (Get+Post) for implementing CRUD operations.
It is worth noting that the following operations are implemented: creating, reading, updating and deleting records from the database.
The View is based on JSP+JSTL pages.

I will focus in more detail on the logic of the application.
1. You can enter the store from a regular user account, or with administrator rights. Authorization and authentication of the next site visitor is performed
using Spring Security (for this purpose, 2 tables have been created in the database: authorities and users). An example of the authentication procedure is shown in Figure 2. The password is entered
into the database based on bcrypt encryption.
2. From an ordinary user account, you can view the product catalog (Figure 3-4), add your favorite products to the cart (in any quantity), and also
make a purchase (Figure 5).
3. From the administrator account, it is additionally possible to change an existing product (Figure 6-7), remove an item from the list, and add a new one (Figure 8).
These operations are performed by clicking on buttons that are inaccessible to an ordinary user (Figure 9).

Thanks.
