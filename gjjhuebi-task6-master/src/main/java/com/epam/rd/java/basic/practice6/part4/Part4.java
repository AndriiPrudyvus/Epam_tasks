package com.epam.rd.java.basic.practice6.part4;

import java.util.Iterator;

public class Part4 {

    public static void main(String[] args) {
        Range range = new Range(3, 10);

        Iterator<Integer> iteratorFirst = range.iterator();

        while (iteratorFirst.hasNext()) {
            System.out.printf("%d ", iteratorFirst.next());
        }
        System.out.println();

        range = new Range(3, 10, true);

        Iterator<Integer> iteratorSecond = range.iterator();

        while (iteratorSecond.hasNext()) {
            System.out.printf("%d ", iteratorSecond.next());
        }
    }
}
