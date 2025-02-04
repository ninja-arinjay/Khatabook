package com.ninja.khatabook.service;
import com.ninja.khatabook.model.Expense;
import com.ninja.khatabook.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;

@Service
public class SummaryService {
    @Autowired
    ExpenseRepository expenseRepository;

    public SummaryService(){

    }

    public Long getSummary(){
        Long summary = expenseRepository.getExpenseSummary();
        return summary != null ? summary : 0L;
    }
    public Long getSummaryByMonth(String month){
        try {
            int monthInt = Integer.parseInt(month);
            List<Expense> expenses = expenseRepository.findAll();
            Long summary = expenses.stream()
                    .filter(expense -> (expense.getDate().getMonthValue() == monthInt
                            && expense.getDate().getYear() == LocalDate.now().getYear()))
                    .mapToLong(Expense::getAmount)
                    .sum();
            return summary != null ? summary : 0L;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid month format. Please provide a numeric month like '02'.");
        }
    }
}
