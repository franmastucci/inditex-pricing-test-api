package com.inditex.price.domain;

import com.inditex.shared.domain.Name;
import lombok.*;

import static com.inditex.utils.CoreConstants.PRODUCT_ID_NULL_ERROR_MSG;


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
 * The class ProductDomain.
 */
public class ProductDomain {

    /** The productId. */
    private Long productId;

    /** The name. */
    private Name name;

    /** The description. */
    private String description;


    /**
     * Creates a builder for the {@code ProductDomain} class.
     *
     * @param productId The unique identifier for the product. Non-null.
     * @return A builder for creating instances of {@code ProductDomain}.
     */

    public static ProductDomainBuilder builder(@NonNull Long productId) {
        return hiddenBuilder().productId(productId);
    }

    public void validate() {

        if (productId == null)
            throw new IllegalStateException(PRODUCT_ID_NULL_ERROR_MSG);

    }

    @Override
    public String toString() {
        return "ProductDomain{" +
                "productId=" + productId +
                ", name=" + name +
                ", description='" + description + '\'' +
                '}';
    }
}




