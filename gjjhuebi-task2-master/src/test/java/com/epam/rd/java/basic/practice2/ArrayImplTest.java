package com.epam.rd.java.basic.practice2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayImplTest {

    private ArrayImpl array;

    private Object[] elements;

    @Before
    public void beforeTest() {

        array = new ArrayImpl();

        array.add('A');

        array.add('B');

        array.add('C');

        elements = new Object[4];

        elements[0] = 'A';

        elements[1] = 'B';

        elements[2] = 'C';
    }

    @Test
    public void shouldAddElement() {
        Assert.assertEquals(array, new ArrayImpl(elements, 3));
    }


    @Test
    public void shouldSetElement() {
        array.set(1, elements[1] = 1);
        Assert.assertEquals(array, new ArrayImpl(elements, 3));
    }


    @Test
    public void shouldGetElement() {
        Assert.assertEquals(elements[1], array.get(1));
    }


    @Test
    public void shouldFindIndexOf() {
        Assert.assertEquals(0, array.indexOf('A'));
    }

    @Test
    public void shouldReturnSize() {
        Assert.assertEquals(array.size(), elements.length);
    }


    @Test
    public void shouldClearArray() {
        elements = new Object[array.size()];
        array.clear();
        Assert.assertEquals(array, new ArrayImpl(elements, 8));
    }

    @After
    public void afterTest() {
        array = null;
        elements = null;
    }
}
