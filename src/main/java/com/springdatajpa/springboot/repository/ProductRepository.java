package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findByName(String name);

    Optional<Product> findById(Long id);

    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameAndDescription(String name, String description);

    Optional<Product> findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameLike(String name);

    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Product> findByNameIn(List<String> names);

    List<Product> findFirst2ByOrderByNameAsc();

    List<Product> findTop1ByOrderByPriceAsc();

    //@Query
    @Query("Select p from Product p where p.name=?1 or p.description=?2")
    Product findByNameOrDescriptionJPQLIndexParam(String name, String description);

    @Query("Select p from Product p where p.name=:name or p.description=:description")
    Product findByNameOrDescriptionJPQLNamedParam(@Param("name") String name,
                                                  @Param("description") String description);

    @Query(value = "select * from product p where p.name=?1 or p.description=?2",
            nativeQuery = true)
    Product findByNameOrDescriptionSQLIndexParam(String name, String description);

    @Query(value = "select * from product p where p.name=:name or p.description=:description",
            nativeQuery = true)
    Product findByNameOrDescriptionSQLNamedParam(@Param("name") String name,
                                                 @Param("description") String description);

    //NamedQuery
    Product findByPrice(BigDecimal price);

    List<Product> findAllOrderByNameDesc();

    @Query(nativeQuery = true)
    Product findByPriceNativeQuery(BigDecimal price);

}
