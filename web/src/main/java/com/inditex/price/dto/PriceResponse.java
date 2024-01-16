package com.inditex.price.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "PriceResponse", description = "PriceResponse data")

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

    /** The startDate. */
    private Date startDate;

    /** The endDate. */
    private Date endDate;

    /** The finalPrice. */
    private BigDecimal finalPrice;

}
