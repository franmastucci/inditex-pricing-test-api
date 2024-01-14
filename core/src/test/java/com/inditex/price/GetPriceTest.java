package com.inditex.price;

import com.inditex.price.application.GetPrice;
import com.inditex.price.domain.PriceDomain;
import com.inditex.price.domain.PriceRepository;
import com.inditex.shared.exception.DomainException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import com.inditex.utils.TestUtils;

public class GetPriceTest {

    @Mock
    PriceRepository priceRepository;

    GetPrice getPrice;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        getPrice = new GetPrice(priceRepository);
    }

    @Test
    void should_return_a_price_domain_object() throws IOException {

        String brandName = "ZARA";
        Long productId = 35455L;
        Timestamp date = new Timestamp(2020,06,16,21,00,00,00);

        var json = TestUtils.fileToJson("mocks/PriceDomain-Mock.json");
        var priceDomain = TestUtils.getObj(json, PriceDomain.class);

        doReturn(priceDomain)
                .when(priceRepository).findMaxPriorityPrice(brandName, productId, date);

        assertEquals(getPrice.getPrice(date, productId, brandName), priceDomain);

    }

    @Test
    void should_throw_domain_exception_for_null_parameters() {
        assertThrows(DomainException.class, () -> {
            getPrice.getPrice(null, null, null);
        });

        assertThrows(DomainException.class, () -> {
            getPrice.getPrice(null, 35455L, "ZARA");
        });

    }

}
