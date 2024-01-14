package com.inditex.price.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

import static com.inditex.utils.CoreConstants.PRICE_ID_NULL_ERROR_MSG;


/**
 * Gets the additional properties.
 *
 * @return the additional properties
 */
@Getter

/**
 * Sets the additional properties.
 *
 * @param additionalProperties the additional properties
 */
@Setter
@Builder(builderMethodName = "hiddenBuilder")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor

/**
 * The class PriceDomain.
 */
public class PriceDomain {

    /** The priceId. */
    private Long priceId;

    /** The brandId. */
    private BrandDomain brandDomain;

    /** The currencyDomain. */
    private CurrencyDomain currencyDomain;

    /** The productDomain. */
    private ProductDomain productDomain;

    /** The startDate. */
    private Date startDate;

    /** The endDate. */
    private Date endDate;

    /** The priority. */
    private Integer priority;

    /** The priceValue. */
    private BigDecimal priceValue;


    /**
     * Creates a builder for the {@code PriceDomain} class.
     *
     * @param priceId       The unique identifier for the price. Non-null.
     * @param brandDomain   The domain object representing the brand. Non-null.
     * @param currencyDomain The domain object representing the currency. Non-null.
     * @param productDomain  The domain object representing the product. Non-null.
     * @return A builder for creating instances of {@code PriceDomain}.
     */

    public static PriceDomainBuilder builder(
            @NonNull Long priceId,
            @NonNull BrandDomain brandDomain,
            @NonNull CurrencyDomain currencyDomain,
            @NonNull ProductDomain productDomain
            ) {
        return hiddenBuilder()
                .priceId(priceId)
                .brandDomain(brandDomain)
                .currencyDomain(currencyDomain)
                .productDomain(productDomain);
    }

    public void validate() {
        brandDomain.validate();
        currencyDomain.validate();
        productDomain.validate();

        if (priceId == null)
            throw new IllegalStateException(PRICE_ID_NULL_ERROR_MSG);
    }

    @Override
    public String toString() {
        return "PriceDomain{" +
                "priceId=" + priceId +
                ", brandDomain=" + brandDomain +
                ", currencyDomain=" + currencyDomain +
                ", productDomain=" + productDomain +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priority=" + priority +
                ", priceValue=" + priceValue +
                '}';
    }

}







