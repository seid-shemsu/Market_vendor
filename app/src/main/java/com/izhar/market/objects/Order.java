package com.izhar.market.objects;

public class Order {
    String id, date, status, item_id, user_id, vendor_id;

    public Order(String id, String date, String status, String item_id, String user_id, String vendor_id) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.item_id = item_id;
        this.user_id = user_id;
        this.vendor_id = vendor_id;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getItem_id() {
        return item_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getVendor_id() {
        return vendor_id;
    }
}
