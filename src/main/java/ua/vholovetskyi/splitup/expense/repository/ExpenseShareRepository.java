package ua.vholovetskyi.splitup.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.vholovetskyi.splitup.expense.model.ExpenseShare;

public interface ExpenseShareRepository extends JpaRepository<ExpenseShare, Long> {
}
