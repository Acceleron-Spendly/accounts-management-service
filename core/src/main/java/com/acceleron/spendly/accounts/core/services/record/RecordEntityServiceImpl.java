package com.acceleron.spendly.accounts.core.services.record;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import com.acceleron.spendly.accounts.api.services.record.RecordEntityService;
import com.acceleron.spendly.accounts.core.services.AbstractEntityService;
import com.acceleron.spendly.accounts.persistence.dao.RecordEntity;
import com.acceleron.spendly.accounts.persistence.repositories.BaseRepository;
import com.acceleron.spendly.accounts.persistence.repositories.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecordEntityServiceImpl extends AbstractEntityService<RecordEntity> implements RecordEntityService {

    public final RecordRepository recordRepository;

    @Override
    protected BaseRepository<RecordEntity> getRepository() {
        return recordRepository;
    }
}
