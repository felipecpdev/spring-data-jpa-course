package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueriesTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void namedJPQLQuery(){
        Product product= productRepository.findByPrice(new BigDecimal(100));
        System.out.println(product.getName());
    }

    @Test
    void namedJPQLQueryFindAllOrderByNameDesc(){
        List<Product> product= productRepository.findAllOrderByNameDesc();
        product.stream().map(Product::getName).forEach(System.out::println);
    }

    @Test
    void findByPriceNativeQuery(){
        Product product= productRepository.findByPriceNativeQuery(new BigDecimal(100));
        System.out.println(product.getName());
    }
}
