package com.example.classes.train;

import java.io.Console;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numToSearch;
        TimeTable timeatable = new TimeTable();
        Train train1 = new Train("Витебск", 21, "12:34");
        timeatable.add(train1);
        Train train2 = new Train("Гомель", 101, "15:00");
        timeatable.add(train2);
        Train train3 = new Train("Гродно", 29, "16:04");
        timeatable.add(train3);
        Train train4 = new Train("Брест", 54, "12:20");
        timeatable.add(train4);
        Train train5 = new Train("Орша", 111, "21:34");
        timeatable.add(train5);
        Train train6 = new Train("Гродно", 66, "08:22");
        timeatable.add(train6);


        printAsTable(timeatable.trains);
        numToSearch = getUserInt("Для сортировки по номеру введите '0', для поиска введите номер поезда: >");
        if(numToSearch == 0){
            timeatable.sortByNumber();
            printAsTable(timeatable.trains);

        }
        else {
            numToSearch = getUserInt("Для поиска введите номер поезда: >");
            Train foundTrain = timeatable.searchForTrain(numToSearch);
            if(timeatable.isInList == true) {
                String trainFound = foundTrain.printString();
                System.out.println(trainFound);
            }else{
                System.out.println("Такого поезда нет в списке!");
            }
        }
        numToSearch = getUserInt("Для сортировки по городу введите '1': >");
        System.out.println(numToSearch);
        timeatable.sortByDirection();
        printAsTable(timeatable.trains);
    }

    public static int getUserInt(String message) {
        int input;
        Scanner sc = new Scanner(System.in);

        System.out.print(message);
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.print(message);
        }
        input = sc.nextInt();

        return input;
    }
    public static void printAsTable(List<Train> list){
        System.out.println("+---------------------------------------------------+");
        System.out.printf("|\t%4s\t|\t%12s\t|\t%12s\t|\n","№","До станции","Отправление");
        System.out.println("+---------------------------------------------------+");
        for(Train train:list){
            System.out.printf("|\t%4s\t|\t%12s\t|\t%12s\t|\n",
                    train.getTrainNumber()
                    ,train.getDestination(),
                    new SimpleDateFormat("HH:mm").format(train.parseTime(train.getDepartureTime())));
            System.out.println("+---------------------------------------------------+");
        }
    }
}
