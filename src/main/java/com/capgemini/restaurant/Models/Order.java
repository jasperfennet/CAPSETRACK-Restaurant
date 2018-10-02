package com.capgemini.restaurant.Models;

import java.time.*;
import javax.persistence.*;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @ManyToMany
    private List<MenuItem> menuItems;
    private int tableNumber;
    private String orderStatus;
    private LocalDateTime time;

    public Order(){}

    public Order(int orderId, List<MenuItem> menuItems, int tableNumber, String orderStatus, LocalDateTime time) {
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
