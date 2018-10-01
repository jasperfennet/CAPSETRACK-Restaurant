package Models;

public class Table {

    //private static int currentNumber = 0;
    private int number, capacity;
    private TableStatus status;
    private TableType type;


    //todo:
    //add tabletype. get capacity from the tabletype.
    public Table(int number,TableType type) {
        this.number = number;
        this.capacity = type.getTableCapacity();
        this.status = TableStatus.AVAILABLE;
        this.type = type;
    }

    public int getNumber() {
        return this.number;
    }
    public void setNumber(int number){
        this.number = number;
    }
    /*private void setNumber(){
        this.number = Table.currentNumber + 1;
        Table.currentNumber = this.number;
    }*/

    public int getCapacity() {
        return this.capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public TableStatus getStatus(){
        return this.status;
    }
    public void changeStatus(TableStatus status){
        this.status = status;
    }

    public TableType getType() {
        return type;
    }

    public void setType(TableType type) {
        this.type = type;
    }


}
