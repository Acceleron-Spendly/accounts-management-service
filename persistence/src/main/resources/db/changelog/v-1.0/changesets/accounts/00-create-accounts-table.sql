CREATE TABLE account (
    id STRING(255) NOT NULL,
    creation_date_time TIMESTAMP,
    deletion_date_time TIMESTAMP,
    logically_deleted BOOL NOT NULL,
    amount NUMERIC,
    color STRING(255),
    currency STRING(255),
    name STRING(255),
    person_id STRING(255),
    type STRING(255),
) PRIMARY KEY(id);