package com.rachel.LPG.services;

import com.rachel.LPG.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final ProductService productService;

    public SearchService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> searchProducts(String searchTerm) {
        return productService.getAllProducts()
                .stream()
                .filter(product ->  product.getName().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }
}

