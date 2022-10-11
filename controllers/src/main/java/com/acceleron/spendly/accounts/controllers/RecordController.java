package com.acceleron.spendly.accounts.controllers;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import com.acceleron.spendly.accounts.api.dto.RecordDTO;
import com.acceleron.spendly.accounts.api.services.record.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.acceleron.spendly.accounts.ControllersConstants.ID;
import static com.acceleron.spendly.accounts.ControllersConstants.RECORDS;

@RestController
@RequestMapping(RECORDS)
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    @GetMapping()
    public List<RecordDTO> findAll() {
        return recordService.findAll();
    }

    @GetMapping(ID)
    public RecordDTO findById(@PathVariable String id) {
        return recordService.findById(id);
    }

    @PostMapping
    public RecordDTO create(@RequestBody RecordDTO account) {
        return recordService.save(account);
    }

    @PutMapping
    public RecordDTO update(@RequestBody RecordDTO account) {
        return recordService.update(account);
    }

    @DeleteMapping
    public RecordDTO delete(@RequestParam String id) {
        return recordService.delete(id);
    }
}
