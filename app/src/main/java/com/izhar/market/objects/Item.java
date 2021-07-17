package com.izhar.market.objects;

import java.util.List;

public class Item {
    String id, name, vendor_id, price, photo, description, category;
    List<String> comments;

    public Item(String id, String name, String vendor_id, String price, String photo, String description, String category) {
        this.id = id;
        this.name = name;
        this.vendor_id = vendor_id;
        this.price = price;
        this.photo = photo;
        this.description = description;
        this.category = category;
    }

    public Item() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVendor_id() {
        return vendor_id;
    }

    public String getPrice() {
        return price;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
