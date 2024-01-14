package com.inditex.price.dto;

import com.inditex.price.domain.PriceDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

/**
 * The class PriceResponse.
 *
 */
public class PriceResponse {

    /** The brandId. */
    private Long brandId;

    /** The brandName. */
    private String brandName;

    /** The pruductId. */
    private Long pruductId;

    /** The productName. */
    private String productName;

    /** The priceId. */
    private Long priceId;

    /** The appDate. */
    private Timestamp appDate;

    /** The finalPrice. */
    private BigDecimal finalPrice;


    public static PriceResponse ToPriceResponse(PriceDomain price, Timestamp date) {
        return PriceResponse.builder()
                .brandId(price.getBrandDomain().getBrandId())
                .brandName(price.getBrandDomain().getName().getValue())
                .pruductId(price.getProductDomain().getProductId())
                .productName(price.getProductDomain().getName().getValue())
                .priceId(price.getPriceId())
                .appDate(date)
                .finalPrice(price.getPriceValue())
                .build();
    }

}
