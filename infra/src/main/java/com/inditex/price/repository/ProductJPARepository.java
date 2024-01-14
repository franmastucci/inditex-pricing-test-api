package com.inditex.price.repository;


import com.inditex.price.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<ProductEntity, Integer> {
}

