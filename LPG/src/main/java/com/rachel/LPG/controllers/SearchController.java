package com.rachel.LPG.controllers;

import com.rachel.LPG.models.Product;
import com.rachel.LPG.models.SearchResponse;
import com.rachel.LPG.services.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("{searchTerm}")
    public SearchResponse search(@PathVariable("searchTerm") String searchTerm) {
        List<Product> results = searchService.searchProducts(searchTerm);
        SearchResponse response = new SearchResponse();
        response.setProducts(results);

        return response;
    }
}
