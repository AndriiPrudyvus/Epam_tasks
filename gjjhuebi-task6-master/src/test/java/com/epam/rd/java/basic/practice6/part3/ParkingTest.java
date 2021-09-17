package com.epam.rd.java.basic.practice6.part3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingTest {
    private static List<Integer> parkingPlaces;

    private static Parking parking;

    @Before
    public void beforeTests() {
        parkingPlaces = new ArrayList<>(4);
        parking = new Parking(4);
        for (int i = 0; i < 4; i++) {
            parkingPlaces.add(0);
        }
    }


    @Test
    public void shouldArriveTrue() {
        Assert.assertTrue(parking.arrive(1));
        Assert.assertTrue(parking.arrive(1));
        Assert.assertTrue(parking.arrive(1));
        Assert.assertTrue(parking.arrive(1));
    }


    @Test
    public void shouldArriveFalseWhenAllPostsOccupiedWithArrive() {
        Assert.assertTrue(parking.arrive(1));
        Assert.assertTrue(parking.arrive(1));
        Assert.assertTrue(parking.arrive(1));
        Assert.assertTrue(parking.arrive(1));
        Assert.assertEquals(new Boolean(false), parking.arrive(1));
    }


    @Test
    public void shouldArriveTrueWhenBusyFromKToEndAndSearchFromStart() {
        Assert.assertTrue(parking.arrive(1));
        Assert.assertTrue(parking.arrive(2));
        Assert.assertTrue(parking.arrive(3));
        Assert.assertTrue(parking.arrive(0));
    }


    @Test
    public void shouldDepartPlaceIfItOccupied() {
        Assert.assertTrue(parking.arrive(0));
        Assert.assertTrue(parking.arrive(1));
        Assert.assertTrue(parking.arrive(2));
        Assert.assertTrue(parking.arrive(3));
        Assert.assertTrue(parking.depart(0));
    }


    @Test
    public void shouldReturnFalseIfPlaceNotOccupiedByUsingDepart() {
        Assert.assertTrue(parking.arrive(1));
        Assert.assertTrue(parking.arrive(2));
        Assert.assertTrue(parking.arrive(3));
        Assert.assertEquals(new Boolean(false), parking.depart(0));
    }
}