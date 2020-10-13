package org.example.steps;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.То;
import org.example.Booking;

public class MySteps {

    @Когда("^Клиент авторизуеться на сайте$")
    public void addLoginAndPassword (){
        Booking.autorizacia();
        System.out.println("Авторизация");
    }

    @И("^Клиент создает заказ$")
    public void userCreateBooking() {
        Booking.createBooking();
        System.out.println("Создание заказа");
    }

    @То("^Клиент проверяет создание заказа$")
    public void userGetBooking() {
        Booking.chek();
        System.out.println("Проверка заказа");
    }
}
