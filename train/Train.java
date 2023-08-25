package com.example.classes.train;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Train {
    //4. Создайте класс Train, содержащий поля: название пункта назначения,
    // номер поезда, время отправления. Создайте данные в массив из пяти
    // элементов типа Train, добавьте возможность сортировки элементов
    // массива по номерам поездов. Добавьте возможность вывода информации о
    // поезде, номер которого введен пользователем. Добавьте возможность
    // сортировки массив по пункту назначения, причем поезда с одинаковыми
    // пунктами назначения должны быть упорядочены по времени отправления.
    private String destination;
    private int trainNumber;
    private String departureTime;

    public Train() {
    }

    public Train(String destination, int trainNumber, String departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String printString(){
        String str = "#" + this.trainNumber + " | " + this.destination + " | " + this.departureTime;
        return str;
    }
    public Date parseTime(String timeString){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date  time = null;
        try {
            time = df.parse(timeString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return time;
    }

}
