package com.acceleron.spendly.accounts.core.services.account;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import com.acceleron.spendly.accounts.api.dto.AccountDTO;
import com.acceleron.spendly.accounts.api.services.account.AccountEntityService;
import com.acceleron.spendly.accounts.api.services.account.AccountService;
import com.acceleron.spendly.accounts.persistence.dao.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final ModelMapper modelMapper;
    private final AccountEntityService accountEntityService;

    @Override
    public AccountDTO findById(String id) {
        return mapAccountModel(accountEntityService.findById(id));
    }

    @Override
    public List<AccountDTO> findAll() {
        return accountEntityService.findAll().stream()
                .map(this::mapAccountModel)
                .toList();
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        return mapAccountModel(accountEntityService.saveOrUpdate(
                mapAccountModel(accountDTO))
        );
    }

    @Override
    public AccountDTO update(AccountDTO accountDTO) {
        return mapAccountModel(accountEntityService.update(
                mapAccountModel(accountDTO))
        );
    }

    @Override
    public AccountDTO delete(String id) {
        return mapAccountModel(accountEntityService.deleteById(id));
    }

    private AccountDTO mapAccountModel(AccountEntity accountEntity) {
        return modelMapper.map(accountEntity, AccountDTO.class);
    }

    private AccountEntity mapAccountModel(AccountDTO accountDTO) {
        return modelMapper.map(accountDTO, AccountEntity.class);
    }
}
