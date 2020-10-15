package com.rachel.LPG.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.rachel.LPG.models.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final CategoryService categoryService;
    public ProductService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    private List<Product> products = new ArrayList<>();
    HashMap<String, String> categories= new HashMap<>();

    @PostConstruct
    public void loadData() {
        String productsFileName = "src/main/resources/products.csv";
        Path productsPath = Paths.get(productsFileName);

        try (BufferedReader productsbr = Files.newBufferedReader(productsPath,
                StandardCharsets.UTF_8)) {
            HeaderColumnNameMappingStrategy<Product> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Product.class);
            CsvToBean<Product> csvToBeanp = new CsvToBeanBuilder<Product>(productsbr)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            products = csvToBeanp.parse();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    public List<Product> getAllProducts() {
        for ( Product product : products) product.setCategoryName(categoryService.getCategory(product));
        return products;
    }

    public List<Product> getProductsByCategory(String category) {
        return products.stream().filter(product -> category.equals(product.getCategoryName())).collect(Collectors.toList());
    }

}
