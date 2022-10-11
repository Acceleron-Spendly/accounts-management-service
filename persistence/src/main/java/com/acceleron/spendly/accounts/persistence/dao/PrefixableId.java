package com.acceleron.spendly.accounts.persistence.dao;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */


import com.acceleron.spendly.accounts.persistence.dao.Identifiable;

public interface PrefixableId extends Identifiable<String> {

    String DEFAULT_PREFIX_ID = "OBJ";

    default String prefix() {
        return DEFAULT_PREFIX_ID;
    }
}
