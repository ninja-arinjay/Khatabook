package com.ninja.khatabook.service;

import com.ninja.khatabook.model.Budget;
import com.ninja.khatabook.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BudgetService {
    @Autowired
    BudgetRepository budgetRepository;

    public boolean setBudget(Budget budget){
        if(budget != null){
            budgetRepository.save(budget);
            return true;
        }
        else{
            return false;
        }
    }
    public Long getBudget(String month){
        Optional<Budget> budget = budgetRepository.findByMonth(month);
        if(budget.isPresent()){
            return budget.get().getMaxLimit();
        }
        return 0L;
    }
}