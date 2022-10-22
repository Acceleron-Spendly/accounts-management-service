CREATE TABLE category (
    id STRING(255) NOT NULL,
    creation_date_time TIMESTAMP,
    deletion_date_time TIMESTAMP,
    logically_deleted BOOL NOT NULL,
    category_level INT64 NOT NULL,
    color STRING(255),
    name STRING(255),
    parent_category_id STRING(255),
    person_id STRING(255),
    CONSTRAINT FK_PARENT_CATEGORY_ID FOREIGN KEY(parent_category_id) REFERENCES category(id),
) PRIMARY KEY(id);