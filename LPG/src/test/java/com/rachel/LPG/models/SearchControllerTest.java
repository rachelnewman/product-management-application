package com.rachel.LPG.models;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnUnsortedProducts() throws Exception {
        mockMvc.perform(get("/search"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.products").isArray());
    }

    @Test
    void shouldReturnUnsortedProductsWithSearchTermAndSort() throws Exception {
        mockMvc.perform(get("/search/knife?sortby=category"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.products").isArray());

        String sorted = mockMvc.perform(get("/search/knife?sortby=category")).toString();
        String unsorted = mockMvc.perform(get("/search/knife")).toString();
        assert(!sorted.equals(unsorted));
    }



}
