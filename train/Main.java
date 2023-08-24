package com.example.classes.train;

import java.io.Console;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numToSearch;
        TimeTable tt = new TimeTable();
        Train train1 = new Train("Витебск", 21, "12:34");
        tt.add(train1);
        Train train2 = new Train("Гомель", 101, "15:00");
        tt.add(train2);
        Train train3 = new Train("Гродно", 29, "16:04");
        tt.add(train3);
        Train train4 = new Train("Брест", 54, "12:20");
        tt.add(train4);
        Train train5 = new Train("Орша", 111, "21:34");
        tt.add(train5);
        Train train6 = new Train("Гродно", 66, "08:22");
        tt.add(train6);


        tt.printAsTable(tt.trains);
        numToSearch = getUserInt("Для сортировки по номеру введите '0', для поиска введите номер поезда: >");
        if(numToSearch == 0){
            tt.sortByNumber();
            tt.printAsTable(tt.trains);
            numToSearch = getUserInt("Для поиска введите номер поезда: >");
            Train foundTrain = tt.searchForTrain(numToSearch);
            if(tt.isInList == true) {
                foundTrain.printString();
            }else{
                System.out.println("Такого поезда нет в списке!");
            }
        }
        else {
            Train foundTrain = tt.searchForTrain(numToSearch);
            foundTrain.printString();
        }
        numToSearch = getUserInt("Для сортировки по городу введите '1': >");
        System.out.println(numToSearch);
        tt.sortByDirection();
        tt.printAsTable(tt.trains);
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
}