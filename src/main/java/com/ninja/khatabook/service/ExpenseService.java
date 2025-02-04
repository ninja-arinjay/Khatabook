package com.ninja.khatabook.service;

import com.ninja.khatabook.model.Expense;
import com.ninja.khatabook.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    private SummaryService summaryService;

    @Autowired
    private BudgetService budgetService;

    public ExpenseService(){

    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public List<Expense> getExpensesByCategory(String category){
        return expenseRepository.findExpensesByCategory(category);
    }

    public boolean addExpense(Expense expense){
        if(expense != null){
            expense.setDate(LocalDate.now());
            expenseRepository.save(expense);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkExpenseWarning(){
        Long summaryOfMonth = summaryService.getSummaryByMonth(String.valueOf(LocalDate.now().getMonthValue()));
        Long budgetLimit = budgetService.getBudget(String.valueOf(LocalDate.now().getMonthValue()));
        if (summaryOfMonth != null && budgetLimit != null && summaryOfMonth >= budgetLimit) {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteExpense(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if(expense.isPresent()){
            expenseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateExpense(Long id, Expense updatedExpense) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if(expense.isPresent()){
            Expense expenseToUpdate = expense.get();
            expenseToUpdate.setDescription(updatedExpense.getDescription());
            expenseToUpdate.setAmount(updatedExpense.getAmount());
            expenseToUpdate.setCategory(updatedExpense.getCategory());
            expenseRepository.save(expenseToUpdate);
            return true;
        }
        return false;
    }
}
