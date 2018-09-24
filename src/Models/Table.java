package Models;

public abstract class Table {

    private int number, capacity;
    private TableStatus status;

    public Table(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
        status = TableStatus.AVAILABLE;
    }

    public int getNumber() {
        return this.number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

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
}
