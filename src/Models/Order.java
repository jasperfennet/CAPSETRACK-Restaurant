package Models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private List<MenuItem> menuItems= new ArrayList<>();
    private int tableNumber;
    private String orderStatus;
    private Date time;

    public Order(int orderId, List<MenuItem> menuItems, int tableNumber, String orderStatus, Date time) {
        this.orderId = orderId;
        this.menuItems = menuItems;
        this.tableNumber = tableNumber;
        this.orderStatus = orderStatus;
        this.time = time;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
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
