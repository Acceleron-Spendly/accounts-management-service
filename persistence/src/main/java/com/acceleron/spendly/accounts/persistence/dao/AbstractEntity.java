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
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static com.acceleron.spendly.accounts.persistence.dao.generators.StringSequenceIdGenerator.GENERATOR_STRATEGY_NAME;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.InheritanceType.JOINED;

@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = JOINED)
@AllArgsConstructor
@RequiredArgsConstructor
public abstract class AbstractEntity implements PrefixableId, Deletable {

    private static final String GENERATOR_NAME = "entity_seq";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = GENERATOR_NAME)
    @GenericGenerator(name = GENERATOR_NAME, strategy = GENERATOR_STRATEGY_NAME)
    protected String id;

    @NonNull
    @Column(updatable=false)
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
