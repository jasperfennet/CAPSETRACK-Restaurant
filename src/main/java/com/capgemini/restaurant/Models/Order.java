package com.capgemini.restaurant.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int orderId;
    private List<MenuItem> menuItems;
    private int tableNumber;
    private String orderStatus;
    private Date time;

    public Order(){}

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

    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    public void removeMenuItem(MenuItem menuItem) {
        this.menuItems.remove(menuItem);
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
