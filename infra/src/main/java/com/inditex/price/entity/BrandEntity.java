package com.inditex.price.entity;

import com.inditex.price.domain.BrandDomain;
import com.inditex.price.domain.CurrencyDomain;
import com.inditex.shared.domain.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BRANDS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRAND_ID")
    private Long brandId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "FOUNDING_YEAR")
    private Date foundingYear;

    public BrandDomain toDomain() {
        return BrandDomain.builder(this.getBrandId())
                .name(new Name(this.getName()))
                .country(this.getCountry())
                .foundingYear(this.getFoundingYear())
                .build();
    }

}
