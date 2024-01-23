package com.inditex.price.adapter;

import com.inditex.price.application.GetPrice;
import com.inditex.price.dto.PriceResponse;
import com.inditex.price.dto.error.ErrorListMessageDTO;
import com.inditex.price.mapper.PriceWebMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

import static com.inditex.utils.WebConstants.*;

/**
 * Controller class for handling price-related endpoints.
 */

@Log4j2
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(PRICE_REQUEST_MAPPING_PATH)
public class PriceController {

	@Autowired
	GetPrice getPrice;



	/**
	 * Retrieves the price for the given date, product, and brand.
	 *
	 * @param date   The date for which the price is requested.
	 * @param product The ID of the product.
	 * @param brand   The name of the brand.
	 * @return A ResponseEntity containing the PriceResponse, with HTTP status OK if successful.
	 */

	@GetMapping
	@Operation(summary = "find the max priority price")
	@ApiResponses(value = {
			@ApiResponse(responseCode = HTTP_CODE_OK, description = "Class found",
					content = @Content(schema = @Schema(implementation = PriceResponse.class))),
			@ApiResponse(responseCode = HTTP_CODE_NO_CONTENT, description = "No content", content = @Content()),
			@ApiResponse(responseCode = HTTP_CODE_BAD_REQUEST, description = "Bad Request. Class is not correct.",
					content = @Content(schema = @Schema(implementation = ErrorListMessageDTO.class))),
			@ApiResponse(responseCode = HTTP_CODE_NOT_FOUND, description = "Class not found",
					content = @Content(schema = @Schema(implementation = ErrorListMessageDTO.class))),
			@ApiResponse(responseCode = HTTP_CODE_INTERNAL_SERVER_ERROR, description = "An exception occurred",
					content = @Content(schema = @Schema(implementation = ErrorListMessageDTO.class)))
	})

	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PriceResponse> getPrice(
			@Parameter(description = DATE_PARAM, required = true, example = PRICE_DATE_EXAMPLE)
			@RequestParam(DATE_PARAM) Timestamp date,
			@Parameter(description = PRODUCT_PARAM, required = true, example = PRICE_PRODUCT_EXAMPLE)
			@RequestParam(PRODUCT_PARAM) Long product,
			@Parameter(description = BRAND_PARAM, required = true, example = PRICE_BRAND_EXAMPLE)
			@RequestParam(BRAND_PARAM) String brand ) {

		log.info(PRICE_LOG_CONTROLLER ,date, brand, product);
		var price = getPrice.getPrice(date,product,brand);

		if (null != price) {
			var priceResponse = PriceWebMapper.INSTANCE.map(price);
			log.info(PRICE_LOG_CONTROLLER_RESPONSE + priceResponse.toString());
			return ResponseEntity.ok().body(priceResponse);
		}

		return ResponseEntity.noContent().build();
	}

}
