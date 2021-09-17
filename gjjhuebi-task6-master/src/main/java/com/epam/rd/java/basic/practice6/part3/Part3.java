package com.epam.rd.java.basic.practice6.part3;

public class Part3 {
    
    public static void main(String[] args) {
        Parking p = new Parking(4);
        p.print();
        try {
            p.arrive(1);
            p.arrive(1);
            p.arrive(1);
            System.out.println("\n" + p.depart(1));
            p.arrive(1);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        p.print();
    }
}
