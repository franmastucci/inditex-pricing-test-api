package com.inditex.price.repository;


import com.inditex.price.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyJPARepository extends JpaRepository<CurrencyEntity, Integer> {
}

