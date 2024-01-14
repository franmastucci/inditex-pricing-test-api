package com.inditex.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Contains API constants.
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebConstants {

    /**
     * The Constant WEB_TRACE.
     */
    public static final String WEB_TRACE = "Web trace: ";

    /**
     * The Constant PRICE_LOG_CONTROLLER.
     */
    public static final String PRICE_LOG_CONTROLLER = WEB_TRACE + "date={}, product={}, brand={}";

    /**
     * The Constant PRICE_LOG_CONTROLLER_RESPONSE.
     */
    public static final String PRICE_LOG_CONTROLLER_RESPONSE = WEB_TRACE + "Response: ";

    /**
     * The Constant PRICE_REQUEST_MAPPING_PATH.
     */
    public static final String PRICE_REQUEST_MAPPING_PATH = "/prices";

    /**
     * The Constant PRICE_REQUEST_MAPPING_PATH.
     */
    public static final String VERSION_REQUEST_MAPPING_PATH = "/version";


}



