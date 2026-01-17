package ua.vholovetskyi.splitup.expense.mapper;

import ua.vholovetskyi.splitup.expense.model.ExpenseShare;

import java.math.BigDecimal;

public class ExpenseShareFactory {

    public static ExpenseShare createExpenseShare(Long expenseId, Long userId, BigDecimal amount) {

        return ExpenseShare.builder()
                .expenseId(expenseId)
                .userId(userId)
                .shareAmount(amount)
                .build();
    }
}
