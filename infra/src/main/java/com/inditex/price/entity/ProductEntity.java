package com.inditex.price.entity;

import com.inditex.price.domain.ProductDomain;
import com.inditex.shared.domain.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    public ProductDomain toDomain( ) {
        return ProductDomain.builder(this.getProductId())
                .description(this.getDescription())
                .name(new Name(this.getName()))
                .build();
    }

}

