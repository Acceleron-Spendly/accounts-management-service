package com.acceleron.spendly.accounts.core.services;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import com.acceleron.spendly.accounts.api.services.BaseEntityService;
import com.acceleron.spendly.accounts.persistence.dao.AbstractEntity;
import com.acceleron.spendly.accounts.persistence.repositories.BaseRepository;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;
import static java.util.Spliterator.ORDERED;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;

public abstract class AbstractEntityService<T extends AbstractEntity> implements BaseEntityService<T, String> {

    protected abstract BaseRepository<T> getRepository();

    /**
     * {@inheritDoc}
     */
    @Override
    public T saveOrUpdate(T entity) {
        return getRepository().save(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T update(T entity) {
        T updatedEntity = null;
        if (nonNull(entity.getId())) {
            updatedEntity = getRepository().save(entity);//TODO fix update
        }
        return updatedEntity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T deleteById(String id) {
        T entity = findById(id);
        if(Objects.nonNull(entity)){
            entity.delete();
            update(entity);
        }
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T findById(String id) {
        return getRepository().findAccountEntityByIdAndLogicallyDeletedIsFalse(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> findAll() {
        return stream(spliteratorUnknownSize(getRepository().findAll().iterator(), ORDERED), false).toList();
    }
}
