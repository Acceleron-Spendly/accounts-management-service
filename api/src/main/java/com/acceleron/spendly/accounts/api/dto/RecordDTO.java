package com.acceleron.spendly.accounts.api.dto;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Currency;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordDTO {

    private BigDecimal targetAmount;
    private LocalDateTime createdTime;
    private BigDecimal amount;
    private String note;
    private String payee;
    private String type;
    private CategoryDTO category;
    private AccountDTO account;
    private Currency currency;
    private LocalDateTime creationDateTime = now();

    private LocalDateTime now() {
        return LocalDateTime.now(ZoneOffset.UTC);
    }
}
