package com.epam.rd.java.basic.practice2;

public class Demo {

    public static void main(String[] args) {
        Array array = new ArrayImpl();

        array.add('A');

        array.add('B');

        array.add('C');

        array.add("Z");

        System.out.print(array.toString());

        array.remove(2);

        System.out.println(array.toString());

        System.out.print(array.indexOf("None"));

        array.clear();
    }
}
