package com.acceleron.spendly.accounts.persistence.dao;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

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

    @NonNull
    private BigDecimal targetAmount;
    @NonNull
    private LocalDateTime createdTime;
    @NonNull
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

    @NonNull
    private Currency currency;

    @Override
    public String prefix() {
        return ID_PREFIX;
    }
}
