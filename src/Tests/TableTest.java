package Tests;

import Models.RoundTable;
import Models.SquareTable;
import Models.Table;
import Models.TableStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    private List<Table> tables = new ArrayList<Table>();
    private TableStatus available, reserved, tooLate;

    @BeforeEach
    void setUp() {
        for(int i = 0; i < 20; i++){
            if(i % 2 == 0)
                tables.add(new SquareTable());
            else
                tables.add(new RoundTable());
        }
        available = TableStatus.AVAILABLE;
        reserved = TableStatus.RESERVED;
        tooLate = TableStatus.TOO_LATE;
    }

    @Test
    void getNumber() {
        for(int i = 0; i < tables.size(); i++){
            assertEquals(i+1, tables.get(i).getNumber());
        }
    }

    @Test
    void setNumber() {
        Table t1 = new SquareTable();
        Table t2 = new SquareTable();
        Table t3 = new RoundTable();
        assertEquals(t1.getNumber()+1, t2.getNumber());
        assertEquals(t1.getNumber()+2, t3.getNumber());
    }

    @Test
    void getCapacity() {
        for(int i = 0; i < tables.size(); i++){
            if(i % 2 == 0)
                assertEquals(4, tables.get(i));
            else
                assertEquals(12, tables.get(i));
        }
    }

    @Test
    void setCapacity() {
        Table t1 = new SquareTable();
        t1.setCapacity(6);
        assertEquals(6, t1.getCapacity());
    }

    @Test
    void getStatus() {
        //A table is initialized with AVAILABLE.
        assertEquals(available, tables.get(0).getStatus());
        assertNotEquals(reserved, tables.get(0).getStatus());
        assertNotEquals(tooLate, tables.get(0).getStatus());
    }

    @Test
    void changeStatus() {
        assertEquals(available, tables.get(0).getStatus());
        tables.get(0).changeStatus(TableStatus.RESERVED);
        assertEquals(reserved, tables.get(0).getStatus());
    }
}