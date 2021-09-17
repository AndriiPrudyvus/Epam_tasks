package com.epam.rd.java.basic.practice6.part4;

import java.util.Iterator;

public class Range implements Iterable<Integer>{
    
    private int n;

    private int m;

    private boolean reverse;

    private int[] numbers;

    public Range(int n, int m) {
        this(n, m, false);
        numbers = new int[m - n];
    }

    public Range(int firstBound, int secBound, boolean reversedOrder) {
        m = firstBound;
        n = secBound;
        reverse = reversedOrder;
        numbers = new int[n - m];
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }
    
    private final class IteratorImpl implements Iterator<Integer> {

        private int i = m;
        private int j = n;
        private int index = 0;
        
        @Override
        public boolean hasNext() {
            return reverse && i != 0 && j >= m || !reverse && i <= n;
        }

        @Override
        public Integer next() {
            if (reverse) {
                return numbers[index] = j--;
            } else {
                return numbers[index] = i++;
            }
        }
    }
}
