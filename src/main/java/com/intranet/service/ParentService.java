package com.intranet.service;

import com.intranet.entity.Parent;
import com.intranet.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public Parent createParent(Parent parent) {
        return parentRepository.save(parent);
    }

    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    public Parent getParentById(Long id) {
        return parentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found with id: " + id));
    }

    public Parent updateParent(Long id, Parent parentDetails) {
        Parent existingParent = parentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found with id: " + id));
        existingParent.setName(parentDetails.getName());
        existingParent.setPhone(parentDetails.getPhone());
        existingParent.setAddress(parentDetails.getAddress());
        return parentRepository.save(existingParent);
    }

    public void deleteParent(Long id) {
        Parent existingParent = parentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found with id: " + id));
        parentRepository.delete(existingParent);
    }
}
