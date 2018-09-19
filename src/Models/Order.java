package Models;

import java.util.Date;


public class Order {

    public Order(int orderId, int menuItem, int tableNumber, String orderStatus, Date time) {
        this.orderId = orderId;
        this.menuItem = menuItem;
        this.tableNumber = tableNumber;
        this.orderStatus = orderStatus;
        this.time = time;
    }

    //
    private int orderId;
    private int menuItem;
    private int tableNumber;
    private String orderStatus;
    private Date time;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(int menuItem) {
        this.menuItem = menuItem;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


}
