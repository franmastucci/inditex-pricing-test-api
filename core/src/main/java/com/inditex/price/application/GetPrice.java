package com.inditex.price.application;
import com.inditex.price.domain.PriceDomain;
import java.sql.Timestamp;

/**
 * The Interface GetPrice.
 */
public interface GetPrice {


    /**
     * Gets price
     *
     * @param date the execution date
     * @param product the product
     * @param brand the brand
     * @return a PriceDomain
     */

    public PriceDomain getPrice(Timestamp date, Long product, String brand);

}
