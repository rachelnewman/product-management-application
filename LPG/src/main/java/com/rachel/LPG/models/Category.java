package com.rachel.LPG.models;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

public class Category {
    @Getter
    @Setter
    @CsvBindByName(column="ID")
    private String id;

    @Getter
    @Setter
    @CsvBindByName(column = "CATEGORY_NAME")
    private String categoryName;

}

