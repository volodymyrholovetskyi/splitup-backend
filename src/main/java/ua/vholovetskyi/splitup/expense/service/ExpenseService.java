package ua.vholovetskyi.splitup.expense.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.vholovetskyi.splitup.expense.controller.dto.CreateExpenseRequest;
import ua.vholovetskyi.splitup.expense.mapper.ExpenseFactory;
import ua.vholovetskyi.splitup.expense.mapper.ExpenseShareFactory;
import ua.vholovetskyi.splitup.expense.repository.ExpenseRepository;
import ua.vholovetskyi.splitup.expense.repository.ExpenseShareRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Transactional
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseShareRepository expenseShareRepository;

    public void createExpense(CreateExpenseRequest expenseReq) {

        var expense = ExpenseFactory.createNewExpense(expenseReq);
        var savedExpenses = expenseRepository.save(expense);

        BigDecimal share = calculateShare(expenseReq);

        for (Long userId : expenseReq.getParticipantUserIds()) {
            var expenseShare = ExpenseShareFactory.createShare(
                    savedExpenses.getId(),
                    userId,
                    share);

            expenseShareRepository.save(expenseShare);
        }
    }

    private BigDecimal calculateShare(CreateExpenseRequest expenseReq) {
        return expenseReq.getAmount()
                .divide(
                        BigDecimal.valueOf(expenseReq.getParticipantUserIds().size()),
                        2,
                        RoundingMode.HALF_UP
                );
    }
}
