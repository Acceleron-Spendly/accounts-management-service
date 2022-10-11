package com.acceleron.spendly.accounts.persistence.dao.generators;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import com.acceleron.spendly.accounts.persistence.dao.PrefixableId;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

import static java.lang.String.format;
import static java.lang.String.join;

public class StringSequenceIdGenerator extends SequenceStyleGenerator {

    public static final String PREFIX_PARAM = "prefix";
    public static final String GENERATOR_STRATEGY_NAME = "com.acceleron.spendly.accounts.persistence.dao.generators.StringSequenceIdGenerator";

    private static final String DELIMITER = "_";
    private static final String NUMBER_FORMAT = "%07d";

    /**
     * {@inheritDoc}
     */
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = PrefixableId.DEFAULT_PREFIX_ID;
        if(object instanceof PrefixableId) {
            prefix = ((PrefixableId) object).prefix();
        }
        return join(DELIMITER, prefix, format(NUMBER_FORMAT, (Long) super.generate(session, object)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        //prefix = ConfigurationHelper.getString(PREFIX_PARAM, params);
    }
}
