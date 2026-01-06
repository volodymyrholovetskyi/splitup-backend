package ua.vholovetskyi.splitup.expense.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "expense_shares")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExpenseShare {

    @Id
    @GeneratedValue
    private Long id;
    private Long expenseId;
    private Long userId;
    private BigDecimal shareAmount;
}
