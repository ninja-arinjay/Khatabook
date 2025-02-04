package com.ninja.khatabook.controller;

import com.ninja.khatabook.model.Budget;
import com.ninja.khatabook.service.BudgetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/budget")
public class BudgetController {
    private BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping
    public ResponseEntity<String> setBudget(@RequestBody Budget budget) {
        boolean isBudgetSet = budgetService.setBudget(budget);
        if (isBudgetSet) {
            return new ResponseEntity<>("Budget was set successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sorry, Failed to set the budget", HttpStatus.NOT_FOUND);
        }
    }

}