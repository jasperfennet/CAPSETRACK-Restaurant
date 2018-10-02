package com.capgemini.restaurant;

import com.capgemini.restaurant.Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    private Table roundTable;
    private Table squareTable;

    @BeforeEach
    void setUp() {
        roundTable = new Table(1, TableType.ROUND);
        squareTable = new Table(2, TableType.SQUARE);
    }

    @Test
    void getNumber() {
        assertEquals(1, roundTable.getNumber());
        assertEquals(2, squareTable.getNumber());
    }

    @Test
    void setNumber() {
        roundTable.setNumber(5);
        assertEquals(5, roundTable.getNumber());
    }

    @Test
    void getCapacity() {
        assertEquals(4, squareTable.getCapacity());
        assertEquals(12, roundTable.getCapacity());

    }

    @Test
    void getStatus() {
        assertEquals(TableStatus.AVAILABLE, roundTable.getStatus());
    }

    @Test
    void setStatus() {
        roundTable.setStatus(TableStatus.TOO_LATE);
        assertEquals(TableStatus.TOO_LATE, roundTable.getStatus());
    }

    @Test
    void getType() {
        assertEquals(TableType.ROUND, roundTable.getType());
    }

    @Test
    void setType() {
        roundTable.setType(TableType.SQUARE);
        assertEquals(TableType.SQUARE, roundTable.getType());
        assertEquals(4,roundTable.getCapacity());

    }
}