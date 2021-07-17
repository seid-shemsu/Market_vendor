package com.izhar.market.objects;

import java.util.List;

public class User {
    String id, name, email, phone, sex, photo, city;
    List<Item> favorite;
    List<History> histories;
    List<String> subscribes;
    List<Order> orders;

    public User() {
    }

    public User(String id, String name, String email, String phone, String sex, String photo, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.photo = photo;
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

    public String getSex() {
        return sex;
    }

    public String getPhoto() {
        return photo;
    }

    public String getCity() {
        return city;
    }

    public List<Item> getFavorite() {
        return favorite;
    }

    public List<History> getHistories() {
        return histories;
    }

    public List<String> getSubscribes() {
        return subscribes;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setFavorite(List<Item> favorite) {
        this.favorite = favorite;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public void setSubscribes(List<String> subscribes) {
        this.subscribes = subscribes;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
