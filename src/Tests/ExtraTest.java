package Tests;


import Models.Extra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExtraTest {

    private Extra extra;

    @BeforeEach
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