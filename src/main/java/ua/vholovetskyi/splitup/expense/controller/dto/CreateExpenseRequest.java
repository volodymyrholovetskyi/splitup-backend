package ua.vholovetskyi.splitup.expense.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateExpenseRequest {

    private Long groupId;
    private Long paidByUserId;
    private BigDecimal amount;
    private String currency;
    private List<Long> participantUserIds;
}
