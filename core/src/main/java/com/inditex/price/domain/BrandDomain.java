package com.inditex.price.domain;

import com.inditex.shared.domain.Name;
import lombok.*;
import java.util.Date;

import static com.inditex.utils.CoreConstants.BRAND_ID_NULL_ERROR_MSG;

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
 * The class BrandDomain.
 */
public class BrandDomain {

    /** The brandId. */
    private Long brandId;

    /** The name. */
    private Name name;

    /** The country. */
    private String country;

    /** The foundingYear. */
    private Date foundingYear;


    /**
     * Creates a builder for the {@code BrandDomain} class.
     *
     * @param brandId The unique identifier for the brand. Non-null.
     * @return A builder for creating instances of {@code BrandDomain}.
     */

    public static BrandDomainBuilder builder(@NonNull Long brandId) {
        return hiddenBuilder().brandId(brandId);
    }

    public void validate() {
        if (brandId == null)
            throw new IllegalStateException(BRAND_ID_NULL_ERROR_MSG);
    }

    @Override
    public String toString() {
        return "BrandDomain{" +
                "brandId=" + brandId +
                ", name=" + name +
                ", country='" + country + '\'' +
                ", foundingYear=" + foundingYear +
                '}';
    }
}
