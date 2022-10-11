package com.acceleron.spendly.accounts.core.services.account;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import com.acceleron.spendly.accounts.api.services.account.AccountEntityService;
import com.acceleron.spendly.accounts.core.services.AbstractEntityService;
import com.acceleron.spendly.accounts.persistence.dao.AccountEntity;
import com.acceleron.spendly.accounts.persistence.repositories.AccountRepository;
import com.acceleron.spendly.accounts.persistence.repositories.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountEntityServiceImpl extends AbstractEntityService<AccountEntity> implements AccountEntityService {

    public final AccountRepository accountRepository;

    @Override
    protected BaseRepository<AccountEntity> getRepository() {
        return accountRepository;
    }
}
