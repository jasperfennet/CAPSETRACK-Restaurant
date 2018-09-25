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

    private List<Table> squareTables = new ArrayList<Table>();
    private List<Table> roundTables = new ArrayList<Table>();
    private int tablesListSize;
    private List<Table> tables = new ArrayList<Table>();
    private TableStatus available, reserved, tooLate;

    @BeforeEach
    void setUp() {
        tablesListSize = 10;
        for(int i = 0; i < tablesListSize; i++){
                squareTables.add(new SquareTable(i+1));
                roundTables.add(new RoundTable(i+11));
        }

        available = TableStatus.AVAILABLE;
        reserved = TableStatus.RESERVED;
        tooLate = TableStatus.TOO_LATE;
    }

    @Test
    void getNumber() {
        for(int i = 0; i < squareTables.size(); i++){
            assertEquals(i+1, squareTables.get(i).getNumber());
        }
    }

    @Test
    void setNumber() {
        Table t1 = new SquareTable(1);
        t1.setNumber(5);
        assertEquals(5, t1.getNumber());
        assertNotEquals(1, t1.getNumber());
    }

    @Test
    void getCapacity() {
        for(int i = 0; i < tablesListSize; i++){
            assertEquals(4, squareTables.get(i).getCapacity());
            assertEquals(12, roundTables.get(i).getCapacity());
        }
    }

    @Test
    void setCapacity() {
        Table t1 = new SquareTable(0);
        t1.setCapacity(6);
        assertEquals(6, t1.getCapacity());
        assertNotEquals(4, t1.getCapacity());
    }

    @Test
    void getStatus() {
        //A table is initialized with AVAILABLE.
        assertEquals(available, squareTables.get(0).getStatus());
        assertNotEquals(reserved, squareTables.get(0).getStatus());
        assertNotEquals(tooLate, squareTables.get(0).getStatus());
    }

    @Test
    void changeStatus() {
        assertEquals(available, squareTables.get(0).getStatus());
        squareTables.get(0).changeStatus(TableStatus.RESERVED);
        assertEquals(reserved, squareTables.get(0).getStatus());
    }
}