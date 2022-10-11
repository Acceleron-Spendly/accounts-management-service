package com.acceleron.spendly.accounts.api.services;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import java.util.List;

/**
 * Abstract service that allows you to perform operations on defined table values from the database that are represented
 * as an Entity
 */
public interface BaseEntityService<E, I> {

    /**
     * Method which allows to save or update value in appropriate table.
     *
     * @param entity representation of value for table.
     *
     * @return value from database table.
     */
    E saveOrUpdate(E entity);

    /**
     * Method which allows to update value in appropriate table.
     *
     * @param entity representation of value for table.
     *
     * @return value from database table.
     */
    E update(E entity);

    /**
     * Method which allows to delete value by id from appropriate table.
     *
     * @param id of value from table.
     *
     * @return value from database table.
     */
    E deleteById(I id);

    /**
     * Method which allows to find value by id from appropriate table.
     *
     * @param id of value from table.
     *
     * @return value from database table.
     */
    E findById(I id);

    /**
     * Method which allows to get all values from appropriate table.
     *
     * @return list of all values from database table.
     */
    List<E> findAll();
}
