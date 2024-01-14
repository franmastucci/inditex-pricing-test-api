package com.inditex.price;

import com.inditex.price.application.GetPrice;
import com.inditex.price.domain.PriceRepository;
import com.inditex.price.repository.PriceJPARepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class GetPriceTest  {
	
    @Autowired
    PriceJPARepository priceJPARepository;

    @Autowired
    PriceRepository priceRepository;

    private GetPrice getPrice;


    @BeforeEach
    void setup() {
        getPrice = new GetPrice(priceRepository);
    }


    @Test
    void deberiaGuardarLaEvaluacion()  {

        String brandName = "ZARA";
        Long productId = 35455L;
        Timestamp date = new Timestamp(120,05,16,21,00,00,00);

        var priceDomainResponse = getPrice.getPrice(date,productId,brandName);

        assertEquals(priceDomainResponse.getCurrencyDomain().getName().getValue(), "EUR");


    }

}