package ua.vholovetskyi.splitup.expense.mapper;

import ua.vholovetskyi.splitup.expense.controller.dto.CreateExpenseRequest;
import ua.vholovetskyi.splitup.expense.model.Expense;

import java.time.LocalDateTime;

public class ExpenseFactory {

    public static Expense createNewExpense(CreateExpenseRequest expenseReq) {

        return Expense.builder()
                .groupId(expenseReq.getGroupId())
                .paidByUserId(expenseReq.getPaidByUserId())
                .amount(expenseReq.getAmount())
                .currency(expenseReq.getCurrency())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
