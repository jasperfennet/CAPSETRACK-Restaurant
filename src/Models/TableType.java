package Models;

public enum TableType {
    ROUND (12), SQUARE(4);

    private int tableCapacity;

    TableType(int tableCapacity){
        this.tableCapacity = tableCapacity;
    }

    public int getTableCapacity(){
        return tableCapacity;
    }
}


