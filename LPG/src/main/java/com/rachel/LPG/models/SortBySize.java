package com.rachel.LPG.models;

import java.util.Comparator;

public class SortBySize implements Comparator<Product> {
    public int compare(Product a, Product b) {
        return -1 * a.getName().replaceAll("\\D+", "").compareTo(b.getName().replaceAll("\\D+", ""));
    }
}
