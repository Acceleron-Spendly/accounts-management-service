package com.acceleron.spendly.accounts.persistence.generators;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import com.acceleron.spendly.accounts.persistence.dao.PrefixableId;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

import static com.acceleron.spendly.accounts.persistence.dao.PrefixableId.DEFAULT_PREFIX_ID;
import static java.lang.Long.parseLong;
import static java.lang.String.format;
import static java.lang.String.join;
import static java.util.regex.Pattern.compile;

public class StringTableSequenceIdGenerator implements IdentifierGenerator {

    public static final String GENERATOR_STRATEGY_NAME =
            "com.acceleron.spendly.accounts.persistence.generators.StringTableSequenceIdGenerator";

    private static final String DELIMITER = "_";
    private static final String NUMBER_FORMAT = "%07d";

    /**
     * {@inheritDoc}
     */
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = DEFAULT_PREFIX_ID;
        if(object instanceof PrefixableId entity) {
            prefix = entity.prefix();
        }

        String query = format("SELECT %s FROM %s",
                session.getEntityPersister(object.getClass().getName(), object).getIdentifierPropertyName(),
                object.getClass().getSimpleName()
        );

        long max = session.createQuery(query).stream()
                .mapToLong(o -> parseLong(compile("([1-9]\\d*)").matcher(o.toString()).group(1)))
                .max()
                .orElse(0L);
        return join(DELIMITER, prefix, format(NUMBER_FORMAT, max + 1));
    }
}
