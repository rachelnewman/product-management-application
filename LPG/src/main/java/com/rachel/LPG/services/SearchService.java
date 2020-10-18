package com.rachel.LPG.services;

import com.rachel.LPG.models.Product;
import com.rachel.LPG.models.SortByCategory;
import com.rachel.LPG.models.SortBySize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final ProductService productService;

    public SearchService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> searchProducts(String searchTerm) {
        if (searchTerm.equals("")) return new ArrayList<>(productService.getAllProducts());
        return productService.getAllProducts()
                .stream()
                .filter(product ->  product.getName().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Product> searchProductsAndSort(String searchTerm, String sortby) {
        List<Product> results = searchProducts(Objects.requireNonNullElse(searchTerm, ""));
        switch (sortby) {
            case "alphabetical":
                results = results.stream().sorted().collect(Collectors.toList());
                break;
            case "category":
                Collections.sort(results, new SortByCategory());
                break;
            case "size-desc":
                Collections.sort(results, new SortBySize());
                Collections.reverse(results);

                break;
            case "size-asc":
                Collections.sort(results, new SortBySize());
                break;
        }
        return results;
    }


}

