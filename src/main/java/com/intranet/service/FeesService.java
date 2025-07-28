package com.intranet.service;

import com.intranet.entity.Fees;
import com.intranet.repository.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeesService {

    @Autowired
    private FeesRepository feesRepository;

    public Fees createFees(Fees fees) {
        return feesRepository.save(fees);
    }

    public List<Fees> getAllFees() {
        return feesRepository.findAll();
    }

    public Fees getFeesById(Long id) {
        return feesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fees not found with id: " + id));
    }

    public Fees updateFees(Long id, Fees feesDetails) {
        Fees existingFees = feesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fees not found with id: " + id));
        existingFees.setAmount(feesDetails.getAmount());
        existingFees.setPaymentDate(feesDetails.getPaymentDate());
        existingFees.setStudent(feesDetails.getStudent());
        return feesRepository.save(existingFees);
    }

    public void deleteFees(Long id) {
        Fees existingFees = feesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fees not found with id: " + id));
        feesRepository.delete(existingFees);
    }
}
