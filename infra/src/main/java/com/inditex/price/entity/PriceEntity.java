package com.inditex.price.entity;

import com.inditex.price.domain.PriceDomain;
import com.inditex.price.domain.ProductDomain;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PRICES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_ID")
    private Long priceId;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "BRAND_ID")
    private BrandEntity brandEntity;

    @ManyToOne
    @JoinColumn(name = "CURR_ID", referencedColumnName = "CURR_ID")
    private CurrencyEntity currencyEntity;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    private ProductEntity productEntity;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE_VALUE")
    private BigDecimal priceValue;

    public PriceDomain toDomain() {
        return PriceDomain.builder(
                        this.getPriceId(),
                        this.getBrandEntity().toDomain(),
                        this.getCurrencyEntity().toDomain(),
                        this.getProductEntity().toDomain()
                )
                .startDate(this.getStartDate())
                .endDate(this.getEndDate())
                .priority(this.getPriority())
                .priceValue(this.getPriceValue())
                .build();
    }

}

