package com.example.demo.constant;

public enum OrderStatus {
    ORDER("预定"),ACTIVE("生效");
    private String name;

    OrderStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
