package com.ninja.khatabook.repository;
import com.ninja.khatabook.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT SUM(e.amount) FROM Expense e")
    Long getExpenseSummary();
    @Query("SELECT e FROM Expense e WHERE e.category LIKE %:category%")
    List<Expense> findExpensesByCategory(@Param("category") String category);

}
