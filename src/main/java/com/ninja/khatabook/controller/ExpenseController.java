package com.ninja.khatabook.controller;

import com.ninja.khatabook.model.Expense;
import com.ninja.khatabook.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
        return new ResponseEntity<>(expenseService.getAllExpenses(), HttpStatus.OK);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<?> getExpensesByCategory(@PathVariable String category){
        List<Expense> expenses = expenseService.getExpensesByCategory(category);
        if (expenses.isEmpty()) {
            return new ResponseEntity<>("No expenses found for the category: " + category, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(expenses, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addExpense(@RequestBody Expense expense) {
        boolean isExpenseAdded = expenseService.addExpense(expense);
        boolean isExpenseWarning = expenseService.checkExpenseWarning();
        String warningMessage = isExpenseWarning ? "Max Limit Reached" : "You are within the limit";

        Map<String, Object> response = new HashMap<>();
        response.put("success", isExpenseAdded);
        response.put("warning", isExpenseWarning);
        response.put("message", warningMessage);

        HttpStatus status = isExpenseAdded ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(response, status);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id){
        boolean isDeleted = expenseService.deleteExpense(id);
        if(isDeleted){
            return new ResponseEntity<>("Expense Deleted Successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Sorry, Not able to delete the expense", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateExpense(@PathVariable Long id, @RequestBody Expense updatedExpense){
        boolean isUpdated = expenseService.updateExpense(id, updatedExpense);
        if(isUpdated){
            return new ResponseEntity<>("Expense Updated Successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Sorry, Not able to update the expense", HttpStatus.NOT_FOUND);
        }
    }
}
