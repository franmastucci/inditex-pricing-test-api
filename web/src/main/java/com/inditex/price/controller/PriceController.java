package com.inditex.price.controller;

import com.inditex.price.application.GetPrice;
import com.inditex.price.dto.PriceResponse;
import com.inditex.price.mapper.PriceWebMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

import static com.inditex.utils.WebConstants.*;

/**
 * Controller class for handling price-related endpoints.
 */
@RestController
@RequestMapping(PRICE_REQUEST_MAPPING_PATH)
@Slf4j
public class PriceController {

	@Autowired
	GetPrice getPrice;

	@Value("${com.inditex.prices-api.version}")
	String version ;

	@GetMapping(path = VERSION_REQUEST_MAPPING_PATH)
	public ResponseEntity<String> versionApi() {
		return ResponseEntity.ok(version);
	}


	/**
	 * Retrieves the price for the given date, product, and brand.
	 *
	 * @param date   The date for which the price is requested.
	 * @param product The ID of the product.
	 * @param brand   The name of the brand.
	 * @return A ResponseEntity containing the PriceResponse, with HTTP status OK if successful.
	 */

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PriceResponse> getPrice(@RequestParam("date") Timestamp date,
												  @RequestParam("product") Long product,
												  @RequestParam("brand") String brand ) {

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
