package ua.vholovetskyi.splitup.expense.db;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.vholovetskyi.splitup.expense.domain.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
