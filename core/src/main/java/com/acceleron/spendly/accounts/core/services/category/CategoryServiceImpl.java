package com.acceleron.spendly.accounts.core.services.category;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import com.acceleron.spendly.accounts.api.dto.CategoryDTO;
import com.acceleron.spendly.accounts.api.services.category.CategoryEntityService;
import com.acceleron.spendly.accounts.api.services.category.CategoryService;
import com.acceleron.spendly.accounts.persistence.dao.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final ModelMapper modelMapper;
    private final CategoryEntityService categoryEntityService;

    @Override
    public CategoryDTO findById(String id) {
        return mapCategoryModel(categoryEntityService.findById(id));
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryEntityService.findAll().stream()
                .map(this::mapCategoryModel)
                .toList();
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        return mapCategoryModel(categoryEntityService.saveOrUpdate(
                mapCategoryModel(categoryDTO))
        );
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        return mapCategoryModel(categoryEntityService.update(
                mapCategoryModel(categoryDTO))
        );
    }

    @Override
    public CategoryDTO delete(String id) {
        return mapCategoryModel(categoryEntityService.deleteById(id));
    }

    private CategoryDTO mapCategoryModel(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, CategoryDTO.class);
    }

    private CategoryEntity mapCategoryModel(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, CategoryEntity.class);
    }
}
