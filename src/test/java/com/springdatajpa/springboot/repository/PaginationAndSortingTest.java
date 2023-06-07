package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void pagination() {
        int pageNo = 0;
        int pageSize = 3;

        //create pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        //findAll method and pass pageable instance
        Page<Product> page = productRepository.findAll(pageable);
        List<Product> productList = page.getContent();

        productList.forEach(product -> {
            System.out.println(product);
        });

        //total pages
        int totalPage = page.getTotalPages();
        //total elements
        long totalElements = page.getTotalElements();
        //number of elements
        int numOfElements = page.getNumberOfElements();
        //size
        int size = page.getSize();
        //last
        boolean isLast = page.isLast();
        //first
        boolean isFirst = page.isFirst();
        System.out.println(totalPage);
        System.out.println(totalElements);
        System.out.println(numOfElements);
        System.out.println(size);
        System.out.println(isLast);
        System.out.println(isFirst);
    }

    @Test
    void sorting() {
        String sortBy = "price";
        String sortDir = "desc";

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        //para multiples campos
        // Sort GroupBySort= sort.and(otro sort)
        List<Product> productList = productRepository.findAll(sort);

        productList.forEach(product -> {
            System.out.println(product);
        });

    }

    @Test
    void paginationAndSortingTogether() {
        String sortBy = "price";
        String sortDir = "desc";

        Sort sort= sortDir.equalsIgnoreCase(Sort.Direction.DESC.name())?
                Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
        int page=0;
        int size=3;
        Pageable pageable= PageRequest.of(page,size,sort);

        Page<Product> page1 = productRepository.findAll(pageable);
        List<Product> productList = page1.getContent();

        productList.forEach(product -> {
            System.out.println(product);
        });

    }
}
