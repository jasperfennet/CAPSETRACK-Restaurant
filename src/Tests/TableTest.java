package Tests;

import Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    //todo:
    //make a list of table that works with tabletype.
    private List<Table> tables = new ArrayList<Table>();
    private int tablesListSize;
    private TableType round, square;

    @BeforeEach
    void setUp() {
        tablesListSize = 10;
        for(int i = 0; i < tablesListSize; i++){
                tables.add(new Table(i+1,TableType.ROUND));
        }
        round = TableType.ROUND;
        square = TableType.SQUARE;
    }

    @Test
    void getNumber() {
        for(int i = 0; i < tables.size(); i++){
            assertEquals(i+1, tables.get(i).getNumber());
        }
    }

    @Test
    void setNumber() {
        Table t1 = new Table(1,TableType.ROUND);
        t1.setNumber(5);
        assertEquals(5, t1.getNumber());
        assertNotEquals(1, t1.getNumber());
    }

    @Test
    void getCapacity() {
        for(int i = 0; i < tablesListSize; i++){
            assertEquals(12, tables.get(i).getCapacity());
        }
    }

    @Test
    void setCapacity() {
        Table t1 = new Table(4 , TableType.ROUND);
        t1.setCapacity(4);
        assertEquals(4, t1.getCapacity());
        assertNotEquals(6, t1.getCapacity());
    }

    @Test
    void getStatus() {
        //A table is initialized with round.
        assertEquals(round, tables.get(0).getType());
        assertNotEquals(square, tables.get(0).getType());
    }

}