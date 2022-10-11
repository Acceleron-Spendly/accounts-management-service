package com.acceleron.spendly.accounts.controllers;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import com.acceleron.spendly.accounts.api.dto.AccountDTO;
import com.acceleron.spendly.accounts.api.services.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.acceleron.spendly.accounts.ControllersConstants.*;

@RestController
@RequestMapping(ACCOUNTS)
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping()
    public List<AccountDTO> findAll() {
        return accountService.findAll();
    }

    @GetMapping(ID)
    public AccountDTO findById(@PathVariable String id) {
        return accountService.findById(id);
    }

    @PostMapping
    public AccountDTO create(@RequestBody AccountDTO account) {
        return accountService.save(account);
    }

    @PutMapping
    public AccountDTO update(@RequestBody AccountDTO account) {
        return accountService.update(account);
    }

    @DeleteMapping
    public AccountDTO delete(@RequestParam String id) {
        return accountService.delete(id);
    }
}
