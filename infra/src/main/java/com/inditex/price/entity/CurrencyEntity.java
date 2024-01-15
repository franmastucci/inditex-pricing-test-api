package com.inditex.price.entity;

import com.inditex.price.domain.CurrencyDomain;
import com.inditex.price.domain.ProductDomain;
import com.inditex.shared.domain.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CURRENCIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CURR_ID")
    private Long currId;

    @Column(name = "CODE")
    private int code;

    @Column(name = "NAME")
    private String name;

}

