package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABD");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        //save product
        Product savedObject = productRepository.save(product);

        //display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod() {
        //find or retrieve on entity
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        //update entity information
        product.setName("updated product 1");
        product.setDescription("updated product 1 description");

        //save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod() {

        //create product
        Product product3 = new Product();
        product3.setName("product 3");
        product3.setSku("103ABD");
        product3.setPrice(new BigDecimal(100));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        //create product
        Product product4 = new Product();
        product4.setName("product 4");
        product4.setDescription("product 4 description");
        product4.setSku("104ABD");
        product4.setPrice(new BigDecimal(100));
        product4.setActive(true);
        product4.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product3, product4));
    }

    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();

        products.forEach(product -> System.out.println(product.getName()));
    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {
        //find entity by id
        Long id = 4L;
        Product product = productRepository.findById(id).get();

        //delete(entity)
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod() {
//        productRepository.deleteAll();
        List<Product> productList = productRepository.findAll();
        productRepository.deleteAll(productList);
    }

    @Test
    void countMethod(){
        long count= productRepository.count();
        System.out.println(count);
    }

    @Test
    void existByIdMethod(){
        Long id=2L;

        boolean result= productRepository.existsById(id);
        System.out.println(result);
    }



}