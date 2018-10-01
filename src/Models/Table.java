package Models;

public class Table {

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


    public int getCapacity() {
        return this.capacity;
    }

    public TableStatus getStatus(){
        return this.status;
    }

    public void setStatus(TableStatus status){
        this.status = status;
    }

    public TableType getType() {
        return type;
    }

    public void setType(TableType type) {
        this.type = type;
        this.capacity = type.getTableCapacity();
    }


}
