package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 3");
        System.out.println(product.toString());
    }

    @Test
    void findByIdMethod() {
        Optional<Product> productOptional = productRepository.findById(1L);
        productOptional.ifPresent(System.out::println);
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> productList = productRepository
                .findByNameOrDescription("producto 3", null);
        productList.forEach(System.out::println);
    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> productList = productRepository
                .findByNameAndDescription("producto 64", null);
        System.out.println(productList.size());
        productList.forEach(System.out::println);
    }

    @Test
    void findDistinctByNameMethod() {
        Optional<Product> product = productRepository
                .findDistinctByName("product 3");
        product.ifPresent(System.out::println);
    }


}
