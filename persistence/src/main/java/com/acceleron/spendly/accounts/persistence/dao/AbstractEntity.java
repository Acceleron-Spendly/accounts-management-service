package com.acceleron.spendly.accounts.persistence.dao;
/*
 * Copyright (c) 2022 Acceleron Inc. (www.acceleron.com).
 * This software is property of Acceleron Inc. You may not
 * use this software or the resources of this software for
 * your own commercial purposes.
 * All rights reserved.
 */

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static com.acceleron.spendly.accounts.persistence.generators.StringTableSequenceIdGenerator.GENERATOR_STRATEGY_NAME;
import static javax.persistence.InheritanceType.*;

@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity implements PrefixableId, Deletable {

    private static final String GENERATOR_NAME = "entity_seq";

    @Id
    @GeneratedValue(generator = GENERATOR_NAME)
    @GenericGenerator(name = GENERATOR_NAME, strategy = GENERATOR_STRATEGY_NAME)
    protected String id;

    @Column(updatable=false, nullable = false)
    private LocalDateTime creationDateTime = now();
    private LocalDateTime deletionDateTime;
    private boolean logicallyDeleted;

    @Override
    public void delete() {
        logicallyDeleted = true;
        deletionDateTime = now();
    }

    private LocalDateTime now() {
        return LocalDateTime.now(ZoneOffset.UTC);
    }
}
