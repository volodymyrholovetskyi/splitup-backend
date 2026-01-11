package ua.vholovetskyi.splitup.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.vholovetskyi.splitup.expense.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
