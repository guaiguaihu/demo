package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class Items<T> {
    Integer total;
    List<T> items = new ArrayList<>();

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
