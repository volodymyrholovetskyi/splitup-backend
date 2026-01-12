--liquibase formatted sql
--changeset vholovetskyi:expense-shares-1

CREATE TABLE IF NOT EXISTS expense_shares
(
    id              BIGSERIAL       NOT NULL,
    expense_id      BIGINT          NOT NULL,
    user_id         BIGINT          NOT NULL,
    share_amount    NUMERIC(12, 2)  NOT NULL,

    CONSTRAINT pk_expense_shares PRIMARY KEY (id),

    CONSTRAINT fk_expense_shares_expense
        FOREIGN KEY (expense_id)
        REFERENCES expenses (id)
        ON DELETE CASCADE
);