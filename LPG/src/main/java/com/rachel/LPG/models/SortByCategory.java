package com.rachel.LPG.models;

import java.util.Comparator;

public class SortByCategory implements Comparator<Product> {
    public int compare(Product a, Product b) {
        return a.getCategoryName().compareTo(b.getCategoryName());
    }
}
