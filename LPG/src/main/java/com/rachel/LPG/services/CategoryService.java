package com.rachel.LPG.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.rachel.LPG.models.Category;
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

@Service
public class CategoryService {
    HashMap<String, String> categories= new HashMap<>();


    @PostConstruct
    public void loadData() {
        String categoriesFileName = "src/main/resources/categories.csv";
        Path categoriesPath = Paths.get(categoriesFileName);
        try (BufferedReader categoriesbr = Files.newBufferedReader(categoriesPath,
                StandardCharsets.UTF_8)) {
            HeaderColumnNameMappingStrategy<Category> cstrategy
                    = new HeaderColumnNameMappingStrategy<>();
            cstrategy.setType(Category.class);
            CsvToBean<Category> csvToBeanc = new CsvToBeanBuilder<Category>(categoriesbr)
                    .withMappingStrategy(cstrategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            for (Category cat : csvToBeanc.parse()) categories.put(cat.getId(), cat.getCategoryName());


        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public String getCategory(Product product){
        return categories.get(product.getCategoryId());
    }
    public List<String> getCategories() {
        return new ArrayList<>(categories.values());
    }
}
