package com.inditex.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Contains API constants.
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InfraConstants {


    /**
     * The Constant INFRA_TRACE.
     */
    public static final String INFRA_TRACE = "Infra trace: ";

    /**
     * The Constant PRICE_LOG_ADAPTER_CALLING_REPOSITORY.
     */
    public static final String PRICE_LOG_ADAPTER_CALLING_REPOSITORY = INFRA_TRACE + "Calling JPA Repository";

    /**
     * The Constant PRICE_LOG_ADAPTER_CALLING_REPOSITORY_EXCEPTION.
     */
    public static final String PRICE_ERROR_EXCEPTION = "Fail retrieving data from DB";


}


