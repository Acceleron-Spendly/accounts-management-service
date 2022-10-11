package com.acceleron.spendly.accounts.persistence.repositories;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import com.acceleron.spendly.accounts.persistence.dao.AccountEntity;
import com.acceleron.spendly.accounts.persistence.dao.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends BaseRepository<CategoryEntity> {

}

