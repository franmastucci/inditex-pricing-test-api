package com.inditex.price.mapper;

import com.inditex.price.domain.PriceDomain;

import com.inditex.price.entity.PriceEntity;
import com.inditex.shared.domain.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceInfraMapper {

    PriceInfraMapper INSTANCE = Mappers.getMapper(PriceInfraMapper.class);


    @Mapping(source = "brandEntity.name", target = "brandDomain.name", qualifiedByName = "mapToName")
    @Mapping(source = "currencyEntity.name", target = "currencyDomain.name", qualifiedByName = "mapToName")
    @Mapping(source = "productEntity.name", target = "productDomain.name", qualifiedByName = "mapToName")
    PriceDomain map(PriceEntity priceEntity);

    @Named("mapToName")
    default Name mapToName(String name) {
        return new Name(name);
    }

}
