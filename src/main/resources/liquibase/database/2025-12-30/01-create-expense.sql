--liquibase formatted sql
--changeset vholovetskyi:expenses-1

CREATE TABLE IF NOT EXISTS expenses
(
    id                  BIGSERIAL       NOT NULL,
    group_id            BIGINT          NOT NULL,
    paid_by_user_id     BIGINT          NOT NULL,
    amount              NUMERIC(12, 2)  NOT NULL,
    currency            VARCHAR(3)      NOT NULL,
    description         VARCHAR(255),
    created_at          TIMESTAMP       NOT NULL,

    CONSTRAINT pk_expenses PRIMARY KEY (id)
);