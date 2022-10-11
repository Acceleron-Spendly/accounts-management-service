package com.acceleron.spendly.accounts.persistence.dao;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import lombok.*;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

import static java.util.Collections.emptyList;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;

@Table(name = CategoryEntity.TABLE_NAME)
@Entity
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CategoryEntity extends AbstractEntity {

    public static final String TABLE_NAME = "category";
    public static final int MAX_CATEGORY_LEVEL = 3;
    private static final String ID_PREFIX = "CTG";

    @NonNull
    private String name;
    private String color;
    private int categoryLevel;

    @Column(name = "parent_category_id", insertable = false, updatable = false)
    private String parentCategoryId;

    @NonNull
    private String personId;

    @OneToMany(fetch = EAGER, cascade = PERSIST)
    @JoinColumn(name="parent_category_id")
    private List<CategoryEntity> childCategories = emptyList();

    @Override
    public String prefix() {
        return ID_PREFIX;
    }
}
