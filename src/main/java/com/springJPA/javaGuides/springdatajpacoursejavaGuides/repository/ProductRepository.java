package com.springJPA.javaGuides.springdatajpacoursejavaGuides.repository;

import com.springJPA.javaGuides.springdatajpacoursejavaGuides.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
