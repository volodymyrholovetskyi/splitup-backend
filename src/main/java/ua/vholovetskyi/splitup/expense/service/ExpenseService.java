package ua.vholovetskyi.splitup.expense.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.vholovetskyi.splitup.expense.repository.ExpenseRepository;
import ua.vholovetskyi.splitup.expense.repository.ExpenseShareRepository;
import ua.vholovetskyi.splitup.expense.model.Expense;
import ua.vholovetskyi.splitup.expense.model.ExpenseShare;
import ua.vholovetskyi.splitup.expense.controller.dto.CreateExpenseRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseShareRepository expenseShareRepository;

    public void createExpense(CreateExpenseRequest request) {

        Expense expense = new Expense();
        expense.setGroupId(request.getGroupId());
        expense.setPaidByUserId(request.getPaidByUserId());
        expense.setAmount(request.getAmount());
        expense.setCurrency(request.getCurrency());
        expense.setCreatedAt(LocalDateTime.now());

        expense = expenseRepository.save(expense);

        BigDecimal share = request.getAmount()
                .divide(
                        BigDecimal.valueOf(request.getParticipantUserIds().size()),
                        2,
                        RoundingMode.HALF_UP
                );

        for (Long userId : request.getParticipantUserIds()) {
            ExpenseShare expenseShare = new ExpenseShare();
            expenseShare.setExpenseId(expense.getId());
            expenseShare.setUserId(userId);
            expenseShare.setShareAmount(share);

            expenseShareRepository.save(expenseShare);
        }
    }
}
