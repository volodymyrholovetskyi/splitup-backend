package ua.vholovetskyi.splitup.expense.web.dto;

import java.math.BigDecimal;
import java.util.List;

public class CreateExpenseRequest {

    private Long groupId;
    private Long paidByUserId;
    private BigDecimal amount;
    private String currency;
    private List<Long> participantUserIds;
}
