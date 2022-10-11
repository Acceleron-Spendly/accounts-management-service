package com.acceleron.spendly.accounts.api.services;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import java.util.List;

public interface BaseService<T> {

    T findById(String id);
    List<T> findAll();
    T save(T accountDTO);
    T update(T accountDTO);
    T delete(String id);
}
