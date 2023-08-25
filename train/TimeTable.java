package com.example.classes.train;

import java.text.SimpleDateFormat;
import java.util.*;

public class TimeTable implements Comparable<String>{
    public List<Train> trains;
    public boolean isInList;

    public TimeTable() {
        this.trains = new ArrayList<>();
        isInList = false;
    }
    public boolean add(Train train){
        if(!String.valueOf(train.getTrainNumber()).isEmpty()
                && !train.getDestination().isEmpty()
                && !train.getDepartureTime().equals(null))
        {
            trains.add(train);
            return true;
        }
        return false;
    }
    public void sortByNumber(){

        this.trains.sort(new Comparator<Train>() {
            @Override
            public int compare(Train train, Train t1) {
                return train.getTrainNumber() - t1.getTrainNumber();
            }
        });
    }
    public void sortByDirection(){
        this.trains.sort(new Comparator<Train>() {
            @Override
            public int compare(Train train, Train t1) {
                return train.getDestination().compareTo(t1.getDestination());
            }
        });
        for(int i = 1; i < trains.size(); i++){
                this.trains.sort(new Comparator<Train>() {
                    @Override
                    public int compare(Train train, Train t1) {
                        return train.parseTime(train.getDepartureTime()).compareTo(t1.parseTime(t1.getDepartureTime()));
                    }
                });
                this.trains.sort(new Comparator<Train>() {
                    @Override
                    public int compare(Train train, Train t1) {
                        return train.getDestination().compareTo(t1.getDestination());
                    }
                });
            }
    }
    
    public Train searchForTrain(int number){
        Train train;
        for (int i = 0; i < trains.size(); i++) {
            if(trains.get(i).getTrainNumber() == number){
                train = trains.get(i);
                isInList = true;
                return train;
            }
            else{
                isInList = false;
            }
        }
        return null;
    }


    @Override
    public int compareTo(String s) {
        for(Train train:trains){
            return train.getDestination().compareTo(s);
        }
        return 0;
    }
    public int compareTo(Date d) {
        for(int i = 1; i < trains.size(); i++){
            if(trains.get(i-1).getDestination().equals(trains.get(i).getDestination()))
            return trains.get(i-1).parseTime(trains.get(i-1).getDepartureTime()).compareTo(d);
        }
        return 0;
    }
}
