package com.rachel.LPG.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SearchResponse {
    @Getter
    @Setter
    private List<Product> products;
}
