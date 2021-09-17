package com.epam.rd.java.basic.practice6.part2;

import java.util.*;

public class Part2 {
    
    public static List<Integer> addArrayListNumber(int n) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arrayList.add(i);
        return arrayList;
    }


    public static List<Integer> addLinkedListNumber(int n) {
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++)
            linkedList.add(i);
        return linkedList;
    }

    public static void main(String[] args) {
        System.out.println("ArrayList#Index: " + removeByIndex(addArrayListNumber(10000), 4) + " ms");
        System.out.println("LinkedList#Index: " + removeByIndex(addLinkedListNumber(10000), 4) + " ms");
        System.out.println("ArrayList#Iterator: " + removeByIterator(addArrayListNumber(10000), 4) + " ms");
        System.out.println("LinkedList#Iterator: " + removeByIterator(addLinkedListNumber(10000), 4) + " ms");
    }

    public static long removeByIndex(final List<Integer> list, final int k) {
        long startTime = System.currentTimeMillis();
        int n = 10000;
        int start = 0;
        int i = (start - 1) % n;
        for (int j = n; j > 0; j--) {
            i = (i + k) % n--;
            list.add(list.remove(i--));
        }
        return System.currentTimeMillis() - startTime;
    }

    public static long removeByIterator(final List<Integer> list, int k) {
        long startTime = System.currentTimeMillis();
        Iterator<Integer> it;
        int index = 0;
        while (list.size() != 1) {
            it = list.iterator();
            index = (index + k - 2) % list.size();
            for (int i = 0; i < index; i++) {
                it.next();
            }
            it.next();
            it.remove();
        }
        return System.currentTimeMillis() - startTime;
    }
}
