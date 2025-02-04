package com.ninja.khatabook.controller;


import com.ninja.khatabook.service.SummaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/summary")
public class SummaryController {
    private SummaryService summaryService;

    public SummaryController(SummaryService summaryService){
        this.summaryService = summaryService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Long>> getSummary(){
        Long summary = summaryService.getSummary();
        HashMap<String, Long> response = new HashMap<>();
        response.put("summary", summary);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{month}")
    public ResponseEntity<Map<String, Long>> getSummaryByMonth(@PathVariable String month){
        Long summary = summaryService.getSummaryByMonth(month);
        HashMap<String, Long> response = new HashMap<>();
        response.put("summary", summary);
        return ResponseEntity.ok(response);
    }
}
