package com.springdatajpa.springboot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQueries(
        {
                @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p where p.price=?1"),
                @NamedQuery(name = "Product.findAllOrderByNameDesc", query = "SELECT p FROM Product p ORDER BY p.name desc")
        }
)
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Product.findByPriceNativeQuery",
                query = "select * from product p where p.price=?1",
                resultClass = Product.class
        )
})
@Table(name = "product", uniqueConstraints = {@UniqueConstraint(name = "sku_unique", columnNames = "stock_keeping_unit")})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;


    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategory category;

}
