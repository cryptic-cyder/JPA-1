package com.springJPA.javaGuides.springdatajpacoursejavaGuides.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table(
        name = "products",
        schema = "javaguides",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit"
                ),
                @UniqueConstraint(
                        name = "lastUpdated_unique",
                        columnNames = "lastUpdated"
                )
        }
)
public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    )
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private Long id;


    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;        //Made unique field by uniqueConstraints above

    @Column(nullable = false)
    private String name;

    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;

    @CreationTimestamp
    private LocalDateTime dateCreated;      //Made unique field by uniqueConstraints above

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

}

/*
   Four Primary Key Generation Strategies
      1. GenerationType.AUTO
      2. GenerationType.IDENTITY
      3. GenerationType.SEQUENCE
      4. GenerationType.TABLE
*/
