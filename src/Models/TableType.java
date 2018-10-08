package Models;

public enum TableType {
    ROUND (12), SQUARE(4);

    private int TableCapacity;

    TableType(int amount ) {
        TableCapacity = amount;
    }

    public int getTableCapacity() {
        return TableCapacity;
    }
  public void setTableCapacity(int tableCapacity) {
        TableCapacity = tableCapacity;
    }
}
