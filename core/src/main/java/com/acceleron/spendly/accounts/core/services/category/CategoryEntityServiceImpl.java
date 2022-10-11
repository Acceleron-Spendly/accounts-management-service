package com.acceleron.spendly.accounts.core.services.category;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import com.acceleron.spendly.accounts.api.services.category.CategoryEntityService;
import com.acceleron.spendly.accounts.core.services.AbstractEntityService;
import com.acceleron.spendly.accounts.persistence.dao.CategoryEntity;
import com.acceleron.spendly.accounts.persistence.repositories.BaseRepository;
import com.acceleron.spendly.accounts.persistence.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryEntityServiceImpl extends AbstractEntityService<CategoryEntity> implements CategoryEntityService {

    public final CategoryRepository categoryRepository;

    @Override
    protected BaseRepository<CategoryEntity> getRepository() {
        return categoryRepository;
    }
}
