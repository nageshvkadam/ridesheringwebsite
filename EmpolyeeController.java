package com.nagesh.controller;

import com.nagesh.entity.Emplyee;
import com.nagesh.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmpolyeeController {
    private final EmployeeRepository repo;

    public EmpolyeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<Emplyee> create(@RequestBody Emplyee employee) {
        Emplyee saved = repo.save(employee);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Emplyee>> getAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emplyee> getById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emplyee> update(@PathVariable Long id, @RequestBody Emplyee input) {
        return repo.findById(id).map(existing -> {
            existing.setFirstName(input.getFirstName());
            existing.setLastName(input.getLastName());
            existing.setEmail(input.getEmail());
            existing.setPosition(input.getPosition());
            existing.setSalary(input.getSalary());
            repo.save(existing);
            return ResponseEntity.ok(existing);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return repo.findById(id).map(e -> {
            repo.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
