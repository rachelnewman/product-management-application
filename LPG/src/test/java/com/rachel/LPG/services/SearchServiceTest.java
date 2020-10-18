package com.rachel.LPG.services;

import com.rachel.LPG.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import static org.mockito.Mockito.when;

public class SearchServiceTest {
    @Mock
    ProductService productService;

    Product product1 = new Product();
    Product product2 = new Product();
    Product product3 = new Product();
    Product product4 = new Product();
    ArrayList<Product> productArrayList = new ArrayList<>();
    ArrayList<Product> searchedProductArrayList = new ArrayList<>();
    ArrayList<Product> categorySortedProductArrayList = new ArrayList<>();
    ArrayList<Product> nameSortedProductArrayList = new ArrayList<>();
    ArrayList<Product> sizeSortedProductArrayList = new ArrayList<>();

    @InjectMocks
    private SearchService searchService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        // Make Products
        product1.setCategoryName("Toys");
        product1.setId("1");
        product1.setName("Balloon");
        product1.setCategoryId("2");
        productArrayList.add(product1);
        product2.setCategoryName("Animals");
        product2.setId("2");
        product2.setName("Aardvark");
        product2.setCategoryId("4");
        productArrayList.add(product2);
        product3.setCategoryName("Shoes");
        product3.setId("3");
        product3.setName("Trainers (size 4)");
        product3.setCategoryId("3");
        productArrayList.add(product3);
        product4.setCategoryName("Shoes");
        product4.setId("4");
        product4.setName("Trainers (size 10)");
        product4.setCategoryId("3");
        productArrayList.add(product4);

        //make product arrays to test against
        searchedProductArrayList.add(product1);
        categorySortedProductArrayList.add(product2);
        categorySortedProductArrayList.add(product3);
        categorySortedProductArrayList.add(product4);
        categorySortedProductArrayList.add(product1);
        nameSortedProductArrayList.add(product2);
        nameSortedProductArrayList.add(product1);
        nameSortedProductArrayList.add(product4);
        nameSortedProductArrayList.add(product3);
        sizeSortedProductArrayList.add(product4);
        sizeSortedProductArrayList.add(product3);
        sizeSortedProductArrayList.add(product1);
        sizeSortedProductArrayList.add(product2);
    }
    @Test
    public void shouldReturnProduct(){
        String searchTerm = "Balloon";
        when(productService.getAllProducts()).thenReturn(productArrayList);
        assertEquals(searchedProductArrayList, searchService.searchProducts(searchTerm));
    }

    @Test
    public void shouldSortByCategory(){
        String searchTerm = "";
        String sortBy = "category";
        when(productService.getAllProducts()).thenReturn(productArrayList);
        assertEquals(categorySortedProductArrayList, searchService.searchProductsAndSort(searchTerm, sortBy));
    }

    @Test
    public void shouldSortByName(){
        String searchTerm = "";
        String sortBy = "alphabetical";
        when(productService.getAllProducts()).thenReturn(productArrayList);
        assertEquals(nameSortedProductArrayList, searchService.searchProductsAndSort(searchTerm, sortBy));
    }

    @Test
    public void shouldReturnAllProductsUnsorted(){
        String searchTerm = "";
        when(productService.getAllProducts()).thenReturn(productArrayList);
        assertEquals(productArrayList, searchService.searchProducts(searchTerm));
    }
    @Test
    public void shouldSortBySize(){
        String searchTerm = "";
        String sortBy= "size-desc";
        when(productService.getAllProducts()).thenReturn(productArrayList);
        assertEquals(sizeSortedProductArrayList, searchService.searchProductsAndSort(searchTerm, sortBy));
    }
}
