package com.acceleron.spendly.accounts.controllers;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import com.acceleron.spendly.accounts.api.dto.CategoryDTO;
import com.acceleron.spendly.accounts.api.services.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.acceleron.spendly.accounts.ControllersConstants.CATEGORIES;
import static com.acceleron.spendly.accounts.ControllersConstants.ID;

@RestController
@RequestMapping(CATEGORIES)
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<CategoryDTO> findAll() {
        return categoryService.findAll();
    }

    @GetMapping(ID)
    public CategoryDTO findById(@PathVariable String id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO account) {
        return categoryService.save(account);
    }

    @PutMapping
    public CategoryDTO update(@RequestBody CategoryDTO account) {
        return categoryService.update(account);
    }

    @DeleteMapping
    public CategoryDTO delete(@RequestParam String id) {
        return categoryService.delete(id);
    }
}
