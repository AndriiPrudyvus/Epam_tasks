package com.epam.rd.java.basic.practice7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user;

    @Before
    public void beforeTest() {
        user = new User("yura", 30, City.LVIV, "yura");
    }

    @Test
    public void shouldGetUserName() {
        Assert.assertEquals("yura", user.getUserName());
    }

    @Test
    public void shouldGetCity() {
        Assert.assertEquals(City.LVIV, user.getCity());
    }

    @Test
    public void shouldGetAge() {
        Assert.assertEquals(30, user.getAge());
    }

    @Test
    public void shouldGeSurName() {
        Assert.assertEquals("yura", user.getSurName());
    }

    @Test
    public void shouldUserEquals() {
        User userTwo = new User("yura", 30, City.LVIV, "yura");
        Assert.assertTrue(user.equals(userTwo));
    }

    @Test
    public void shouldUserHashCode() {
        User userTwo = new User("yura", 30, City.LVIV, "yura");
        Assert.assertEquals(userTwo.hashCode(), user.hashCode());
    }

    @Test
    public void shouldUserToString() {
        String expected = "User{userName='yura', age=30, city=LVIV, surName='yura'}";
        Assert.assertEquals(expected, user.toString());
    }
}
