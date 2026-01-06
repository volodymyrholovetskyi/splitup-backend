package ua.vholovetskyi.splitup.expense.db;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.vholovetskyi.splitup.expense.domain.ExpenseShare;

public interface ExpenseShareRepository extends JpaRepository<ExpenseShare, Long> {
}
