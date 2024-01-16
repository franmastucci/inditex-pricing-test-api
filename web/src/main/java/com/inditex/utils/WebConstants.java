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

    //API responseCodes
    /** The Constant HTTP_CODE_OK. */
    public static final String HTTP_CODE_OK =  "200";

    /** The Constant HTTP_CODE_NOT_FOUND. */
    public static final String HTTP_CODE_NOT_FOUND =  "404";

    /** The Constant HTTP_CODE_BAD_REQUEST. */
    public static final String HTTP_CODE_BAD_REQUEST =  "400";

    /** The Constant HTTP_CODE_UNAUTHORIZED. */
    public static final String HTTP_CODE_UNAUTHORIZED =  "401";

    /** The Constant HTTP_CODE_FORBIDDEN. */
    public static final String HTTP_CODE_FORBIDDEN = "403";

    /** The Constant HTTP_CODE_UNPROCESSABLE_ENTITY. */
    public static final String HTTP_CODE_UNPROCESSABLE_ENTITY = "422";

    /** The Constant HTTP_CODE_TOO_MANY_REQUESTS. */
    public static final String HTTP_CODE_TOO_MANY_REQUESTS = "429";

    /** The Constant HTTP_CODE_INTERNAL_SERVER_ERROR. */
    public static final String HTTP_CODE_INTERNAL_SERVER_ERROR = "500";

    /** The Constant HTTP_CODE_SERVICE_UNAVAILABLE. */
    public static final String HTTP_CODE_SERVICE_UNAVAILABLE =  "503";

    /** The Constant HTTP_CODE_NO_CONTENT. */
    public static final String HTTP_CODE_NO_CONTENT = "204";

}



