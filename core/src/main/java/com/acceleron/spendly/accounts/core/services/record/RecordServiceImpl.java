package com.acceleron.spendly.accounts.core.services.record;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import com.acceleron.spendly.accounts.api.dto.RecordDTO;
import com.acceleron.spendly.accounts.api.services.record.RecordEntityService;
import com.acceleron.spendly.accounts.api.services.record.RecordService;
import com.acceleron.spendly.accounts.persistence.dao.RecordEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {

    private final ModelMapper modelMapper;
    private final RecordEntityService recordEntityService;

    @Override
    public RecordDTO findById(String id) {
        return mapRecordModel(recordEntityService.findById(id));
    }

    @Override
    public List<RecordDTO> findAll() {
        return recordEntityService.findAll().stream()
                .map(this::mapRecordModel)
                .toList();
    }

    @Override
    public RecordDTO save(RecordDTO recordDTO) {
        return mapRecordModel(recordEntityService.saveOrUpdate(
                mapRecordModel(recordDTO))
        );
    }

    @Override
    public RecordDTO update(RecordDTO recordDTO) {
        return mapRecordModel(recordEntityService.update(
                mapRecordModel(recordDTO))
        );
    }

    @Override
    public RecordDTO delete(String id) {
        return mapRecordModel(recordEntityService.deleteById(id));
    }

    private RecordDTO mapRecordModel(RecordEntity recordEntity) {
        return modelMapper.map(recordEntity, RecordDTO.class);
    }

    private RecordEntity mapRecordModel(RecordDTO recordDTO) {
        return modelMapper.map(recordDTO, RecordEntity.class);
    }
}
