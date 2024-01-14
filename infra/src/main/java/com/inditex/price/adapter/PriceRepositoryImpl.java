package com.inditex.price.adapter;

import com.inditex.price.domain.PriceDomain;
import com.inditex.price.domain.PriceRepository;
import com.inditex.price.repository.PriceJPARepository;
import com.inditex.shared.exception.InfraException;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

import static com.inditex.utils.InfraConstants.*;

/** The Constant log. */
@Log4j2

/**
 * The class PriceRepositoryImpl.
 */
@Repository
public class PriceRepositoryImpl implements PriceRepository {

    @Autowired
    PriceJPARepository priceJPARepository;


    @Override
    public PriceDomain findMaxPriorityPrice(String brandName, Long productId, Timestamp appDate) {

        try {
            log.info(PRICE_LOG_ADAPTER_CALLING_REPOSITORY);
            var price = priceJPARepository.findMaxPriorityPrice(brandName, productId, appDate);

            if (price.isPresent())
                return price.get().toDomain();

        } catch (DataIntegrityViolationException e) {
            log.error(PRICE_ERROR_EXCEPTION);
            throw new InfraException(e.getMessage());

        } catch (Exception e) {
            log.error(PRICE_ERROR_EXCEPTION);
            throw new InfraException(PRICE_ERROR_EXCEPTION+ e.getMessage());
        }

        return null;

    }

}
