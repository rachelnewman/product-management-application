package com.rachel.LPG.models;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvIgnore;
import lombok.Getter;
import lombok.Setter;

public class Product implements Comparable<Product>{
    @Getter
    @Setter
    @CsvBindByName(column="ID")
    private String id;

    @Getter
    @Setter
    @CsvBindByName(column="NAME")
    private String name;

    @Getter
    @Setter
    @CsvBindByName(column="CATEGORY_ID")
    private String categoryId;

    @CsvIgnore
    @Setter
    @Getter
    private String categoryName;

    @Override
    public int compareTo(Product p) {
        return this.getName().toLowerCase().compareTo((p).getName().toLowerCase());
    }
}

