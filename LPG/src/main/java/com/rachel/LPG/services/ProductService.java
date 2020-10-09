package com.rachel.LPG.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.rachel.LPG.models.Product;
import org.springframework.asm.TypeReference;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        String productsFileName = "src/main/resources/products.csv";
        Path productsPath = Paths.get(productsFileName);
        String categoriesFileName = "src/main/resources/products.csv";
        Path categoriesPath = Paths.get(categoriesFileName);
        try (BufferedReader productsbr = Files.newBufferedReader(productsPath,
                StandardCharsets.UTF_8)) {
            HeaderColumnNameMappingStrategy<Product> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Product.class);
            CsvToBean<Product> csvToBean = new CsvToBeanBuilder<Product>(productsbr)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            products = csvToBean.parse();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        try (BufferedReader categoriesbr = Files.newBufferedReader(categoriesPath,
                StandardCharsets.UTF_8)) {
            HeaderColumnNameMappingStrategy<Product> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Product.class);
            CsvToBean<Product> csvToBean = new CsvToBeanBuilder<Product>(categoriesbr)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            products = csvToBean.parse();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    public List<Product> getAllProducts() {
        return products;
    }

}
