package ua.vholovetskyi.splitup.expense.controller.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vholovetskyi.splitup.expense.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<?> createExpense(@RequestBody CreateExpenseRequest expenseRequest) {
        Long expenseId = expenseService.createExpense(expenseRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new CreateExpenseResponse(expenseId));
    }
}
