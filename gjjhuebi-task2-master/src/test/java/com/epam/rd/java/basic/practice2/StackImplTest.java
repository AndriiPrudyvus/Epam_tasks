package com.epam.rd.java.basic.practice2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackImplTest {

    private StackImpl stack;

    private Object[] stackObjects;

    @Before
    public void beforeTest() {

        stack = new StackImpl();

        stack.push('A');

        stack.push('B');

        stack.push('C');

        stack.push('D');

        stackObjects = new Object[4];

        stackObjects[0] = 'A';

        stackObjects[1] = 'B';

        stackObjects[2] = 'C';

        stackObjects[3] = 'D';
    }

    @Test
    public void shouldPushElement() {
        Assert.assertEquals(new StackImpl(stackObjects), stack);
    }

    @Test
    public void shouldReturnSize() {
        Assert.assertEquals(4, stack.size());
    }

    @Test
    public void shouldClearStack() {
        stack.clear();
        stackObjects = new Object[stack.size()];
        Assert.assertEquals(new StackImpl(stackObjects), stack);
    }

    @Test
    public void shouldGetPopElement() {
        stack.pop();

        stackObjects = new Object[3];

        stackObjects[0] = 'A';

        stackObjects[1] = 'B';

        stackObjects[2] = 'C';

        Assert.assertEquals(new StackImpl(stackObjects), stack);
    }

    @Test
    public void shouldGetTopElement() {
        Object top = stack.top();

        Assert.assertEquals(new StackImpl(stackObjects), stack);

        Assert.assertEquals('D', top);
    }
}
