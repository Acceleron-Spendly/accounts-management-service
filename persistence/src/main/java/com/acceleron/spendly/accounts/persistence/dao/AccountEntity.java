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

import static com.acceleron.spendly.accounts.persistence.dao.AccountEntity.*;

@Table(name = TABLE_NAME)
@Entity
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity extends AbstractEntity {

    public static final String TABLE_NAME = "account";
    private static final String ID_PREFIX = "ACC";

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private String personId;

    @Override
    public String prefix() {
        return ID_PREFIX;
    }
}
