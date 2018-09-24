package Tests;

import Models.RoundTable;
import Models.SquareTable;
import Models.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    private List<Table> tables = new ArrayList<Table>();

    @BeforeEach
    void setUp() {
        for(int i = 0; i < 20; i++){
            if(i % 2 == 0)
                tables.add(new SquareTable());
            else
                tables.add(new RoundTable());
        }
    }

    @Test
    void getNumber() {
        for(int i = 0; i < tables.size(); i++){
            assertEquals(i+1, tables.get(i));
        }
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
    }

    @Test
    void getStatus() {
    }

    @Test
    void changeStatus() {
    }
}