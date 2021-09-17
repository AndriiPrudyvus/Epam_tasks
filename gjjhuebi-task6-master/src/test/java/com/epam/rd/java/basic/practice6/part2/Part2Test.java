package com.epam.rd.java.basic.practice6.part2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2Test {
    
    @Test
    public void shouldAddArrayListNumber() {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        Assert.assertEquals(arrayList, Part2.addArrayListNumber(10000));
    }


    @Test
    public void shouldAddLinkedListNumber() {
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        Assert.assertEquals(linkedList, Part2.addLinkedListNumber(10000));
    }


    @Test
    public void shouldRemoveByIndexArrayList() {
        List<Integer> list = Part2.addArrayListNumber(10000);
        long startTime = System.currentTimeMillis();
        int n = 10000;
        int start = 0;
        int i = (start - 1) % n;
        for (int j = n; j > 0; j--) {
            i = (i + 4) % n--;
            list.add(list.remove(i--));
        }
        long end = System.currentTimeMillis();
        Assert.assertNotEquals(startTime - end, Part2.removeByIndex(Part2.addArrayListNumber(10000), 4));
    }


    @Test
    public void shouldRemoveByIndexLinkedList() {
        List<Integer> list = Part2.addLinkedListNumber(10000);
        long startTime = System.currentTimeMillis();
        int n = 10000;
        int start = 0;
        int i = (start - 1) % n;
        for (int j = n; j > 0; j--) {
            i = (i + 4) % n--;
            list.add(list.remove(i--));
        }
        long end = System.currentTimeMillis();

        Assert.assertNotEquals(startTime - end, Part2.removeByIndex(Part2.addLinkedListNumber(10000), 4));
    }


    @Test
    public void shouldRemoveByIteratorArrayList() {
        List<Integer> list = Part2.addArrayListNumber(10000);
        long startTime = System.currentTimeMillis();
        Iterator<Integer> it;
        int index = 0;
        while (list.size() != 1) {
            it = list.iterator();
            index = (index + 4 - 2) % list.size();
            for (int i = 0; i < index; i++) {
                it.next();
            }
            it.next();
            it.remove();
        }
        long end = System.currentTimeMillis();
        Assert.assertNotEquals(startTime - end, Part2.removeByIterator(Part2.addArrayListNumber(10000), 4));
    }


    @Test
    public void shouldRemoveByIteratorLinkedList() {
        List<Integer> linkedList = Part2.addLinkedListNumber(10000);
        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator;
        int index = 0;
        while (linkedList.size() != 1) {
            iterator = linkedList.iterator();
            index = (index + 4 - 2) % linkedList.size();
            for (int i = 0; i < index; i++) {
                iterator.next();
            }
            iterator.next();
            iterator.remove();
        }
        long end = System.currentTimeMillis();
        Assert.assertNotEquals(startTime - end, Part2.removeByIterator(Part2.addLinkedListNumber(10000), 4));
    }
}