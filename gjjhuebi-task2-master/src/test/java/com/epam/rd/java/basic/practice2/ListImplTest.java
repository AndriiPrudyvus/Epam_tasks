package com.epam.rd.java.basic.practice2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListImplTest {

    private List list;

    @Before
    public void beforeTest() {
        list = new ListImpl();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
    }

    @Test
    public void shouldFindFirst() {
        Assert.assertEquals(list.getFirst(), list.getFirst());
    }
}