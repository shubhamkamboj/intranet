package com.intranet.controller;

import com.intranet.entity.Fees;
import com.intranet.service.FeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fees")
public class FeesController {

    @Autowired
    private FeesService feesService;

    // Create
    @PostMapping
    public ResponseEntity<Fees> createFees(@RequestBody Fees fees) {
        return ResponseEntity.ok(feesService.createFees(fees));
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<Fees>> getAllFees() {
        return ResponseEntity.ok(feesService.getAllFees());
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Fees> getFeesById(@PathVariable Long id) {
        return ResponseEntity.ok(feesService.getFeesById(id));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Fees> updateFees(@PathVariable Long id, @RequestBody Fees fees) {
        return ResponseEntity.ok(feesService.updateFees(id, fees));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFees(@PathVariable Long id) {
        feesService.deleteFees(id);
        return ResponseEntity.noContent().build();
    }
}
