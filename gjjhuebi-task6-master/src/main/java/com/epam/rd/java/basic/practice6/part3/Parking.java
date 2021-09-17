package com.epam.rd.java.basic.practice6.part3;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    
     private List<Integer> parkingPlaces;
     
     public Parking(int capacity) {
        parkingPlaces = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            parkingPlaces.add(0);
        }
    }
    
    public boolean arrive(int k) {
        if (k > parkingPlaces.size() || k < 0) {
            throw new IllegalArgumentException("wrong index");
        }
        int count = k;
        if (parkingPlaces.get(k).equals(0)) {
            parkingPlaces.set(k, 1);
            return true;
        }
        for (int i = k; i < parkingPlaces.size(); i++) {
            if (parkingPlaces.get(i).equals(0)) {
                parkingPlaces.set(i, 1);
                return true;
            }
            ++count;
        }
        if (count == parkingPlaces.size()) {
            for (int i = 0; i < parkingPlaces.size(); i++) {
                if (parkingPlaces.get(i).equals(0)) {
                    parkingPlaces.set(i, 1);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean depart(int k) {
        if (k < 0 || k > parkingPlaces.size()) {
            throw new IllegalArgumentException("wrong index");
        }
        if (parkingPlaces.get(k).equals(1)) {
            parkingPlaces.set(k, 0);
            return true;
        }
        return false;
    }
    
    public void print() {
        parkingPlaces.stream().forEach(System.out::print);
    }
}
