package com.rachel.LPG.controllers;

import com.rachel.LPG.models.Product;
import com.rachel.LPG.models.SearchResponse;
import com.rachel.LPG.services.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(value = {"", "{searchTerm}"})
    public SearchResponse search(@PathVariable(required = false) String searchTerm, @RequestParam(required = false) String sortby) {
        List<Product> results;
        if (sortby == null) { results = searchService.searchProducts(Objects.requireNonNullElse(searchTerm, ""));}
        else { results = searchService.searchProductsAndSort(searchTerm, sortby);}
        SearchResponse response = new SearchResponse();
        response.setProducts(results);
        return response;
    }


}
