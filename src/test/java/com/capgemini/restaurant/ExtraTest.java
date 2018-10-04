package com.capgemini.restaurant;


import com.capgemini.restaurant.Models.Extra;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ExtraTest {

    private Extra extra;

    @Before
    public void setUp() throws Exception {
    extra = new Extra("Child Chair", 0.00);
    }

    @Test
    public void getName() {
        assertEquals("Child Chair", extra.getName());
    }

    @Test
    public void setName() {
        extra.setName("Children Chair");
        assertEquals("Children Chair", extra.getName());

    }

    @Test
    public void getPrice() {
        extra.setPrice(0.15);
        assertEquals(0.15, extra.getPrice());

    }


    @Test
    public void setPrice() {
        assertEquals(0.00, extra.getPrice());
    }
}