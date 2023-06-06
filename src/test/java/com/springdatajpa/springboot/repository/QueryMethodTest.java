package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    @Test
    void findByPriceGreaterThanMethod(){
        List<Product> productList = productRepository
                .findByPriceGreaterThan(new BigDecimal(10.00));
        System.out.println(productList.size());
    }

    @Test
    void findByPriceLessThanMethod(){
        List<Product> productList = productRepository
                .findByPriceLessThan(new BigDecimal(10.00));
        System.out.println(productList.size());
    }

    @Test
    void findByNameContainingMethod(){
        List<Product> productList = productRepository
                .findByNameContaining("product 3");
        System.out.println(productList.size());
    }
    @Test
    void findByNameLikeMethod(){
        List<Product> productList = productRepository
                .findByNameLike("product 3");
        System.out.println(productList.size());
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product> productList = productRepository
                .findByPriceBetween(new BigDecimal(1),new BigDecimal(100.0));
        System.out.println(productList.size());
    }
    @Test
    void findByDateCreatedBetweenMethod(){
        LocalDateTime startDate= LocalDateTime.of(2023,5,1,4,5);
        LocalDateTime endDate= LocalDateTime.of(2023,6,5,19,5);
        List<Product> productList = productRepository
                .findByDateCreatedBetween(startDate,endDate);
        System.out.println(productList.size());
    }

    @Test
    void findByNameInMethod(){
        List<Product> productList = productRepository
                .findByNameIn(List.of("product 3","product 4"));
        System.out.println(productList.size());
    }

    @Test
    void findFirst2ByOrderByNameAscMethod(){
        List<Product> productList = productRepository
                .findFirst2ByOrderByNameAsc();
        productList
                .forEach(product -> System.out.println(product.getName()));
    }
    @Test
    void findTop1ByOrderByPriceAscMethod(){
        List<Product> productList = productRepository
                .findTop1ByOrderByPriceAsc();
        System.out.println(productList.size());
    }


}
