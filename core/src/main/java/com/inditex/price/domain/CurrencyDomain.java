package com.inditex.price.domain;

import com.inditex.shared.domain.Name;
import lombok.*;

import static com.inditex.utils.CoreConstants.CURR_ID_NULL_ERROR_MSG;


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
 * The class CurrencyDomain.
 */
public class CurrencyDomain {

    /** The currId. */
    private Long currId;

    /** The code. */
    private Integer code;

    /** The name. */
    private Name name;


    /**
     * Creates a builder for the {@code CurrencyDomain} class.
     *
     * @param currId The unique identifier for the currency. Non-null.
     * @return A builder for creating instances of {@code CurrencyDomain}.
     */

    public static CurrencyDomainBuilder builder(@NonNull Long currId) {
        return hiddenBuilder().currId(currId);
    }

    public void validate() {
        if (currId == null)
            throw new IllegalStateException(CURR_ID_NULL_ERROR_MSG);
    }

    @Override
    public String toString() {
        return "CurrencyDomain{" +
                "currId=" + currId +
                ", code=" + code +
                ", name=" + name +
                '}';
    }

}


