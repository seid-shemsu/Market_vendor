package com.izhar.market.objects;

import java.util.List;

public class Vendor {
    String id, name, email, phone, address, city;
    List<Item> posts;
    List<String> subscribers;
    List<Order> orders;

    public Vendor() {
    }

    public Vendor(String id, String name, String email, String phone, String address, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public List<Item> getPosts() {
        return posts;
    }

    public List<String> getSubscribers() {
        return subscribers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setPosts(List<Item> posts) {
        this.posts = posts;
    }

    public void setSubscribers(List<String> subscribers) {
        this.subscribers = subscribers;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
