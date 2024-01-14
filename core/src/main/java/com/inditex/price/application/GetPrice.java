package com.inditex.price.application;

import com.inditex.price.domain.PriceDomain;
import com.inditex.price.domain.PriceRepository;
import com.inditex.shared.exception.DomainException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

import static com.inditex.utils.CoreConstants.PRICE_ERROR_EXCEPTION;
import static com.inditex.utils.CoreConstants.PRICE_LOG_USE_CASE;


@Service

/** The Constant log. */
@Log4j2

/**
 * Instantiates a new GetPrice.
 *
 * @param priceRepository the priceRepository
 */
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data

/**
 * The Class GetPrice.
 */
public class GetPrice {

    @Autowired
    private final PriceRepository priceRepository;


    public PriceDomain getPrice(Timestamp date, Long product, String brand) {

        try {
            log.info(PRICE_LOG_USE_CASE);
            var priceDomain =  priceRepository.findMaxPriorityPrice(brand, product, date);
            priceDomain.validate();
            return priceDomain;

        } catch(IllegalStateException e) {
            log.error(PRICE_ERROR_EXCEPTION);
            throw new DomainException(PRICE_ERROR_EXCEPTION + e.getMessage());

        } catch(NullPointerException e) {
            log.error(PRICE_ERROR_EXCEPTION);
            throw new DomainException(PRICE_ERROR_EXCEPTION);
        }

    }

}