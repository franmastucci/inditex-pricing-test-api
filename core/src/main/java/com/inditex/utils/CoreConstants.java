package com.inditex.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Contains API constants.
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoreConstants {

    /**
     * The Constant CORE_TRACE.
     */
    public static final String CORE_TRACE = "Core trace: ";

    /**
     * The Constant PRICE_LOG_USE_CASE.
     */
    public static final String PRICE_LOG_USE_CASE = CORE_TRACE + "Calling Repository from Domain";

    /**
     * The Constant PRICE_ERROR_EXCEPTION.
     */
    public static final String PRICE_ERROR_EXCEPTION = "Fail retrieving data.";

    /**
     * The Constant NAME_REGEX_VALIDATION.
     */
    public static final String NAME_REGEX_VALIDATION =  "^[A-Za-záéíóúÁÉÍÓÚñÑüÜ\\s\\-\\.]+(?:\\s+[A-Za-záéíóúÁÉÍÓÚñÑüÜ\\s\\-\\.]+)*$";


    /**
     * The Constant NAME_VALIDATION_ERROR_MSG.
     */
    public static final String NAME_VALIDATION_ERROR_MSG =  "Name is not valid";


    /**
     * The Constant FIELD_ERROR_MSG.
     */
    public static final String FIELD_ERROR_MSG =  "The field: ";

    /**
     * The Constant CAN_NOT_BE_NULL_ERROR_MSG.
     */
    public static final String CAN_NOT_BE_NULL_ERROR_MSG =  " can not be null";

    /**
     * The Constant BRAND_ID_NULL_ERROR_MSG.
     */
    public static final String BRAND_ID_NULL_ERROR_MSG = FIELD_ERROR_MSG + "brandId" + CAN_NOT_BE_NULL_ERROR_MSG;

    /**
     * The Constant CURR_ID_NULL_ERROR_MSG.
     */
    public static final String CURR_ID_NULL_ERROR_MSG = FIELD_ERROR_MSG + "currId" + CAN_NOT_BE_NULL_ERROR_MSG;

    /**
     * The Constant PRICE_ID_NULL_ERROR_MSG.
     */
    public static final String PRICE_ID_NULL_ERROR_MSG = FIELD_ERROR_MSG + "priceId" + CAN_NOT_BE_NULL_ERROR_MSG;

    /**
     * The Constant PRODUCT_ID_NULL_ERROR_MSG.
     */
    public static final String PRODUCT_ID_NULL_ERROR_MSG = FIELD_ERROR_MSG + "productId" + CAN_NOT_BE_NULL_ERROR_MSG;


}


