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

import java.util.Currency;

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

    @NonNull
    private String name;
    @NonNull
    private String type;
    @NonNull
    private String amount;
    @NonNull
    private String color;
    @NonNull
    private Currency currency;
    @NonNull
    private String personId;

    @Override
    public String prefix() {
        return ID_PREFIX;
    }
}
