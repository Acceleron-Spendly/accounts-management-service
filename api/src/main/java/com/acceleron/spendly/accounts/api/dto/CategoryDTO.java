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

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private String id;
    private String name;
    private String color;
    private int categoryLevel;
    private String personId;
    private List<CategoryDTO> childCategories = emptyList();

    public List<CategoryDTO> getChildCategories() {
        return unmodifiableList(childCategories);
    }
}
