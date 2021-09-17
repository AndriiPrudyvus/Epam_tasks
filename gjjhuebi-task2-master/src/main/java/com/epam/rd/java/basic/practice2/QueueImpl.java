package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class QueueImpl implements Queue {
    
    private Object[] queue;

    private int rear;

    private int it;

    private int size;

    public QueueImpl() {
        this.queue = new Object[4];
        this.rear = -1;
        this.it = 0;
        this.size = 4;
    }

    public QueueImpl(Object[] queue) {
        this.queue = queue;
        this.rear = -1;
        this.it = 0;
        this.size = queue.length;
    }

    public QueueImpl(int size) {
        this.queue = new Object[size];
        this.rear = -1;
        this.it = 0;
        this.size = size;
    }
    @Override
    public void clear() {
        queue = new Object[0];
    }

    @Override
    public int size() {
        return queue.length;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private int value = 0;

        @Override
        public boolean hasNext() {
            if (value < size) {
                value++;
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
                return queue[value - 1];
        }
    }

    private void grow() {
        Object[] objects = new Object[queue.length];
        for (int i = 0, j = 0; i < queue.length; i++, j++) {
            objects[j] = queue[i];
        }
        queue = objects;
    }

    @Override
    public void enqueue(Object element) {
         if (it <= queue.length - 1) {
            queue[++rear] = element;
            it++;
        } else {
            grow();
        }
    }

    @Override
    public Object dequeue() {
        Object[] objects = new Object[queue.length - 1];
        Object firstElement = queue[queue.length - 1];
        for (int i = 0; i < queue.length - 1; i++) {
            objects[i] = queue[i];
        }
        queue = objects;
        return firstElement;
    }

    @Override
    public Object top() {
       Object object = null;
        if (queue.length != 0) {
            object = queue[queue.length - 1];
        }
        return object;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < queue.length; i++) {
            stringBuilder.append(queue[i]);
            if (i < queue.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return String.valueOf(stringBuilder);
    }
    
    
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        QueueImpl objects = (QueueImpl) object;
        if (queue == objects.queue) {
            return true;
        }

        if (queue == null || objects.queue == null) {
            return false;
        }

        int length = queue.length;
        return objects.queue.length == length;
    }

    @Override
    public int hashCode() {
        if (queue == null) {
            return 0;
        }
        int result = 1;
        for (Object element : queue)
            result = 31 * result + (element == null ? 0 : element.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Queue queue = new QueueImpl();

        queue.enqueue('A');

        queue.enqueue('B');

        queue.enqueue('C');

        queue.enqueue('D');

        System.out.print(queue.size());

        System.out.print(queue.top());

        System.out.print(queue.toString());

        Iterator<Object> iterator = queue.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.print(queue.dequeue());

        queue.clear();
    }

}
