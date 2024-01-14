package com.inditex.price.repository;


import com.inditex.price.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandJPARepository extends JpaRepository<BrandEntity, Integer> {
}

