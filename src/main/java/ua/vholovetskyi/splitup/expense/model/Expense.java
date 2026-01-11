package ua.vholovetskyi.splitup.expense.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expense {

    @Id
    @GeneratedValue
    private Long id;
    private Long groupId;
    private Long paidByUserId;
    private BigDecimal amount;
    private String currency;
    private String description;
    private LocalDateTime createdAt;
}
