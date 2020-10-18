package com.rachel.LPG.models;

import org.springframework.util.StringUtils;

import java.util.Comparator;

import static java.lang.Integer.parseInt;

public class SortBySize implements Comparator<Product> {
    public int compare(Product a, Product b) {
        String sizeA = a.getName().replaceAll("\\D+", "").trim();
        String sizeB = b.getName().replaceAll("\\D+", "").trim();
        if (StringUtils.isEmpty(sizeA)){
             return -1;
            }
        if(StringUtils.isEmpty(sizeB)) {
            return 1;
        }
        return parseInt(sizeA) - parseInt(sizeB);
    }
}
