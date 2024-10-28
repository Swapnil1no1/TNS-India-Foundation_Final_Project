package com.tns.fooddeliverysystem.entities;
public class Customer {
    private int id;
    private String username;
    private long contactNo;
    private Cart cart;

    public Customer(int id, String username, long contactNo) {
        this.id = id;
        this.username = username;
        this.contactNo = contactNo;
        this.cart = new Cart();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public long getContactNo() {
        return contactNo;
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", username='" + username + "', contactNo=" + contactNo + "}";
    }
}
