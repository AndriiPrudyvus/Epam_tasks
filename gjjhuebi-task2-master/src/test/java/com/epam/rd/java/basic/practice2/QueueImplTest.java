package com.epam.rd.java.basic.practice2;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueImplTest {

    private QueueImpl queue;

    private Object[] elements;

    @Before
    public void beforeTest() {

        queue = new QueueImpl();

        queue.enqueue('A');

        queue.enqueue('B');

        queue.enqueue('C');

        elements = new Object[4];

        elements[0] = 'A';

        elements[1] = 'B';

        elements[2] = 'C';
    }

    @Test
    public void shouldAddElement() {
        Assert.assertEquals(queue, new QueueImpl(elements));
    }

    @Test
    public void shouldGetSize() {
        Assert.assertEquals(4, queue.size());
    }

    @Test
    public void shouldDequeElement() {
        Object deQueue = queue.dequeue();
        Assert.assertEquals(deQueue, elements[3]);
    }
}
