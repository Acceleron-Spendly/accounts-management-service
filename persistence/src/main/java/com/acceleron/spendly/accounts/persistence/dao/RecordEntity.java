package com.acceleron.spendly.accounts.persistence.dao;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = RecordEntity.TABLE_NAME)
@Entity
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecordEntity extends AbstractEntity {

    public static final String TABLE_NAME = "record";
    private static final String ID_PREFIX = "RCD";

    private BigDecimal targetAmount;

    @Column(nullable = false)
    private BigDecimal amount;

    private String note;
    private String payee;
    private String type;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;

    @Column(nullable = false)
    private String currency;

    @Override
    public String prefix() {
        return ID_PREFIX;
    }
}
