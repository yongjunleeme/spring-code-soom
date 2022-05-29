package com.codesoom.assignment.controllers;

import com.codesoom.assignment.application.ProductService;
import com.codesoom.assignment.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    private List<Product> list() {
        return productService.getProducts();
    }

    @GetMapping("{id}")
    private Product detail(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Product create(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PatchMapping("{id}")
    private Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("{id}")
    private Product delete(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
