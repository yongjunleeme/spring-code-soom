package com.codesoom.assignment.controllers;

import com.codesoom.assignment.ProductNotFoundException;
import com.codesoom.assignment.application.ProductService;
import com.codesoom.assignment.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class) // 클래스 선택적으로 테스트할 때
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @BeforeEach
    void setUp() {
        Product product = new Product("쥐돌이", "냥이월드", 10);
        given(productService.getProducts()).willReturn(List.of(product));
        given(productService.getProduct(1L)).willReturn(product);
        given(productService.getProduct(100L)).willThrow(new ProductNotFoundException(100L));
        given(productService.createProduct(product)).willReturn(product);
        given(productService.updateProduct(eq(1L), any(Product.class)))
                .will(invocation -> {
                    Long id = invocation.getArgument(0);
                    Product source = invocation.getArgument(1);
                    return new Product(
                            id,
                            source.getName(),
                            source.getMaker(),
                        source.getPrice()
                    );
                });
    }

    @Test
    void list() throws Exception {
        mockMvc.perform(get("/products")
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("쥐돌이")));
    }

    @Test
    void detailWithExistedProduct() throws Exception {
        mockMvc.perform(get("/products/1")
                        .accept(MediaType.APPLICATION_JSON_UTF8)) // accept
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("쥐돌이")));
    }

    @Test
    void detailWithNotExistedProduct() throws Exception {
        mockMvc.perform(get("/products/100"))
                .andExpect(status().isNotFound());
    }

    @Test
    void createProduct() throws Exception {
        mockMvc.perform(post("/products")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON)  // contentType
                        .content("\"name\": \"쥐돌이\", \"maker\": \"냥이월드\", \"price\": 10}")
                )
                .andExpect(status().isCreated());

        verify(productService).createProduct(any(Product.class));
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(patch("/products/1")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON)  // contentType
                        .content("\"name\": \"쥐순이\", \"maker\": \"냥이월드\", \"price\": 10}"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("쥐순이")));

        verify(productService).updateProduct(1L, any(Product.class));
    }
}
