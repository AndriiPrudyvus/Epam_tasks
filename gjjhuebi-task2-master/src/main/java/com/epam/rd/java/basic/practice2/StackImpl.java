package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class StackImpl implements Stack {

    private Object[] stack;

    private int size;

    private int currentIndex;

    public StackImpl() {
        stack = new Object[4];
        size = 4;
    }
    
    public StackImpl(Object[] stack) {
        this.stack = stack;
        this.size = stack.length;
    }

    public StackImpl(int initialSize) {
        this.stack = new Object[initialSize];
    }
    
    @Override
    public void clear() {
        stack = new Object[0];
    }

    @Override
    public int size() {
        return stack.length;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        int fromBeginIndexStack = 0;

        int fromEndIndexStack = size;
        
        @Override
        public boolean hasNext() {
            if (fromBeginIndexStack < stack.length) {
                fromBeginIndexStack++;
                fromEndIndexStack--;
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
                return stack[fromEndIndexStack - 1];
        }
    }
    
    private void grow() {
        Object[] objects = new Object[stack.length];
        for (int i = 0, j = 0; i < stack.length; i++, j++) {
            objects[j] = stack[i];
        }
        stack = objects;
    }

    @Override
    public void push(Object element) {
        if (currentIndex <= stack.length - 1) {
            stack[currentIndex++] = element;
        } else {
            grow();
        }
    }

    @Override
    public Object pop() {
        Object[] objects = new Object[stack.length - 1];
        Object firstElement = stack[stack.length - 1];
        for (int i = 0; i < stack.length - 1; i++) {
            objects[i] = stack[i];
        }
        stack = objects;
        if (currentIndex == 0) {
            return stack[0];
        }
        return firstElement;
    }

    @Override
    public Object top() {
        Object temp = null;
        if (stack.length != 0) {
            temp = stack[stack.length - 1];
        }
        return temp;
    }
    
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        StackImpl objects = (StackImpl) object;
        if (stack == objects.stack) {
            return true;
        }

        if (stack == null || objects.stack == null) {
            return false;
        }

        int length = stack.length;
        return objects.stack.length == length;
    }

    @Override
    public int hashCode() {
        if (stack == null) {
            return 0;
        }
        int result = 1;
        for (Object element : stack)
            result = 31 * result + (element == null ? 0 : element.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < stack.length; i++) {
            stringBuilder.append(stack[i]);
            if (i < stack.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return String.valueOf(stringBuilder);
    }

    public static void main(String[] args) {
        Stack stack = new StackImpl();

        stack.push('A');

        stack.push('B');

        stack.push('C');

        System.out.print(stack.toString());

        System.out.print(stack.top());

        System.out.print(stack.pop());

        Iterator<Object> iterator = stack.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        stack.clear();
    }

}
