package com.inditex.price.domain;

import java.sql.Timestamp;

/**
 * The Interface PriceRepository.
 */

public interface PriceRepository {


    /**
     * Find a max priority price
     *
     * @param brandName the execution brandName
     * @param productId the productId
     * @param appDate the appDate
     * @return a PriceDomain
     */

    public PriceDomain findMaxPriorityPrice(String brandName, Long productId, Timestamp appDate) ;

}