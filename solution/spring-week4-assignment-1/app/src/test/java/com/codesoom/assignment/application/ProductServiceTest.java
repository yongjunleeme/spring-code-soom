package com.codesoom.assignment.application;

import com.codesoom.assignment.ProductNotFoundException;
import com.codesoom.assignment.domain.Product;
import com.codesoom.assignment.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ProductServiceTest {

    private ProductService productService;

    private ProductRepository productRepository = mock(ProductRepository.class);

    private Product product;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productRepository);

        Product product = new Product(1L, "쥐돌이", "냥이월드", 10);

        given(productRepository.findAll()).willReturn(List.of(product));

        given(productRepository.findById(1L)).willReturn(Optional.of(product));

        given(productRepository.save(any(Product.class))).will(invocation -> {
            Product source = invocation.getArgument(0);
            return new Product(
                    2L,
                    source.getName(),
                    source.getMaker(),
                    source.getPrice()
            );
        });
    }

    @Test
    void getProducts() {
        List<Product> products = productService.getProducts();

        assertThat(products).isNotEmpty();

        Product product = products.get(0);

        assertThat(product.getName()).isEqualTo("쥐돌이");
    }


    @Test
    void getProduct() {
        Product product = productService.getProduct(1L);

        assertThat(product.getName()).isEqualTo("쥐돌이");
    }

    @Test
    void getProductWithNotExistId() {
        assertThatThrownBy(() -> productService.getProduct(1000L))
                .isInstanceOf(ProductNotFoundException.class);
    }

    @Test
    void createProduct() {
        Product source = productService.createProduct(
                new Product("쥐", "냥", 2));
        verify(productRepository).save(any(Product.class));

        assertThat(source.getId()).isEqualTo(2L);
        assertThat(source.getName()).isEqualTo("쥐");
    }

    @Test
    void change() {
        Product source = productService.createProduct(
                new Product("쥐", "냥", 2));

        Product product = productService.createProduct(
                new Product("코", "드", 2));

        source.change(product);

        assertThat(product.getName()).isEqualTo("코");
    }

    @Test
    void update() {
        Product source = productService.createProduct(
                new Product("쥐", "냥", 2));

        Product product = productService.updateProduct(1L, source);

        assertThat(product.getId()).isEqualTo(1L);
    }

    @Test
    void updateProductWithNotExistProduct() {
        Product source = new Product("쥐", "냥", 222);

        assertThatThrownBy(() -> productService.updateProduct(1000L, source))
                .isInstanceOf(ProductNotFoundException.class);
    }

    @Test
    void deleteProductWithExistedId() {
        productService.deleteProduct(1L);

        verify(productRepository).delete(any(Product.class));
    }

    @Test
    void deleteProductWithNotExistedId() {
        assertThatThrownBy(() -> productService.deleteProduct(1000L))
                .isInstanceOf(ProductNotFoundException.class);

    }
}
