package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class ArrayImpl implements Array {
    
    
    private Object[] array;

    private int currentIndex;

    public ArrayImpl() {
        this.array = new Object[4];
        this.currentIndex = 0;
    }

    public ArrayImpl(int count) {
        this.array = new Object[count];
    }

    public ArrayImpl(Object[] array, int count) {
        this.array = array;
        this.currentIndex = count;
    }

	@Override
    public void clear() {
        array = new Object[size()];
    }

	@Override
    public int size() {
        return array.length;
    }
	
	@Override
    public Iterator<Object> iterator() {
	    return new IteratorImpl();
    }
	
	private class IteratorImpl implements Iterator<Object> {
	     int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex < ArrayImpl.this.currentIndex) {
                currentIndex++;
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
                return array[currentIndex - 1];
        }
    }
    
     private void resize() {
        Object[] objects = new Object[array.length];

        for (int i = 0; i < array.length; i++) {
            objects[i] = array[i];
        }
        array = objects;
    }
	
	@Override
    public void add(Object element) {
         if (currentIndex == array.length - 1) {
            resize();
        }
        array[currentIndex] = element;
        currentIndex++;
    }

	@Override
    public void set(int index, Object element) {
        if (index < currentIndex && element != null && index >= 0) {
            array[index] = element;
        }
    }

	@Override
    public Object get(int index) {
       if (index >= 0 && index < currentIndex) {
            return array[index];
        }
        return -1;
    }

	@Override
    public int indexOf(Object element) {
       for (int i = 0; i < currentIndex; i++) {
            final Object object = array[i];
            if (object != null && object.equals(element)) {
                return i;
            }
        }
        return -1;
    }

	@Override
    public void remove(int index) {
         Object[] objects = new Object[array.length - 1];

        for (int i = 0; i < index; i++) {
            objects[i] = array[i];
        }

        for (int i = index; i < array.length - 1; i++) {
            objects[i] = array[i + 1];
        }
        array = objects;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < currentIndex; i++) {
            stringBuilder.append(array[i]);
            if (i < currentIndex - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        ArrayImpl objects = (ArrayImpl) object;
        if (array == objects.array) {
            return true;
        }

        if (array == null || objects.array == null) {
            return false;
        }

        int length = array.length;
        return objects.array.length == length;
    }

    @Override
    public int hashCode() {
        if (array == null) {
            return 0;
        }
        int result = 1;
        for (Object element : array)
            result = 31 * result + (element == null ? 0 : element.hashCode());
        return result;
    }

    public static void main(String[] args) {
        ArrayImpl array = new ArrayImpl();

        array.add('A');

        array.add('B');

        array.add('C');

        System.out.print(array.get(2));

        System.out.print(array.size());

        array.set(2, "None");

        System.out.print(array.toString());

        array.remove(2);

        System.out.println(array.toString());

        System.out.print(array.indexOf("None"));

        final Iterator<Object> iterator = array.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        array.clear();
    }

}
