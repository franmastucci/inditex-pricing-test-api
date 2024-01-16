package com.inditex.price.mapper;

import com.inditex.price.domain.BrandDomain;
import com.inditex.price.domain.PriceDomain;
import com.inditex.price.domain.ProductDomain;
import com.inditex.price.dto.PriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceWebMapper {

    PriceWebMapper INSTANCE = Mappers.getMapper(PriceWebMapper.class);


    @Mapping(source = "priceId", target = "priceId")
    @Mapping(source = "brandDomain", target = "brandId")
    @Mapping(source = "brandDomain", target = "brandName")
    @Mapping(source = "productDomain", target = "pruductId")
    @Mapping(source = "productDomain", target = "productName")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "priceValue", target = "finalPrice")
    PriceResponse map(PriceDomain priceDomain);

    default Long mapBrandId(BrandDomain brandDomain) {
        return brandDomain != null ? brandDomain.getBrandId() : null;
    }

    default String mapBrandName(BrandDomain brandDomain) {
        return brandDomain != null && brandDomain.getName() != null ? brandDomain.getName().getValue() : null;
    }

    default Long mapProductId(ProductDomain productDomain) {
        return productDomain != null ? productDomain.getProductId() : null;
    }

    default String mapProductName(ProductDomain productDomain) {
        return productDomain != null && productDomain.getName() != null ? productDomain.getName().getValue() : null;
    }

}
