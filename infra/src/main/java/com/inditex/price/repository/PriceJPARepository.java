package com.inditex.price.repository;

import com.inditex.price.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.Optional;

/**
 * JPA repository for the {@link PriceEntity} entity.
 */
public interface PriceJPARepository extends JpaRepository<PriceEntity, Integer> {

    /**
     * Searches and returns the {@link PriceEntity} entity with the highest priority
     * for a given brand, product, and date.
     *
     * @param brandName The name of the brand.
     * @param productId The ID of the product.
     * @param appDate   The application date.
     * @return An {@link Optional} containing the {@link PriceEntity} entity with the highest priority,
     *         or an empty container if no entity is found that meets the criteria.
     */
    @Query(value = "SELECT * FROM PRICES P " +
            "JOIN BRANDS B ON B.BRAND_ID = P.BRAND_ID " +
            "WHERE B.NAME = :brandName " +
            "AND P.PRODUCT_ID = :productId " +
            "AND P.START_DATE <= :appDate " +
            "AND P.END_DATE >= :appDate " +
            "ORDER BY P.PRIORITY DESC " +
            "LIMIT 1", nativeQuery = true)
    Optional<PriceEntity> findMaxPriorityPrice(
            @Param("brandName") String brandName,
            @Param("productId") Long productId,
            @Param("appDate") Timestamp appDate
    );

}
