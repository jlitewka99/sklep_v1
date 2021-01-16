package com.AdditionalComponents;

public class Category {
    private String category;
    private int count;

    public Category(String category, int count) {
        this.category = category;
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public int getCount() {
        return count;
    }
}
