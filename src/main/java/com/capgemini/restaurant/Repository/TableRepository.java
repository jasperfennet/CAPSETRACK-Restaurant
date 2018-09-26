package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.RoundTable;
import com.capgemini.restaurant.Models.SquareTable;
import com.capgemini.restaurant.Models.Table;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TableRepository {

    private Map<Integer, Table> tables = new HashMap<>();

    @PostConstruct
    public void generateTable() {
        save(new RoundTable(123));
        save(new SquareTable(124));
    }

    public void save(Table newTable) {
        this.tables.put(newTable.getNumber(), newTable);
    }

    public Collection<Table> findAll() {
        return this.tables.values();
    }

    public Table findByTableNR(int tableNR) {
        return this.tables.get(tableNR);
    }

    public void deleteByTableNR(int tableNr) {
        this.tables.remove(tableNr);
    }

    public Table updateTable(int tableNR, Table update) {
        Table table = this.findByTableNR(tableNR);
        deleteByTableNR(tableNR);
        table.setNumber(update.getNumber());
        table.setCapacity(update.getCapacity());
        save(table);

        return table;
    }

}
