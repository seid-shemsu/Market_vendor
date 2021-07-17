package com.izhar.market.objects;

import java.util.List;

public class History {
    List<Order> orders;

    public History(List<Order> orders) {
        this.orders = orders;
    }

    public History() {
    }

    public List<Order> getOrders() {
        return orders;
    }

}
