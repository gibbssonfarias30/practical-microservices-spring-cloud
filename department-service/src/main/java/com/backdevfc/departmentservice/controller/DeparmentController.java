package com.backdevfc.departmentservice.controller;


import com.backdevfc.departmentservice.model.Department;
import com.backdevfc.departmentservice.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RequestMapping("/departments")
@RestController
public class DeparmentController {

    private final IDepartmentService departmentService;

    @GetMapping
    ResponseEntity<List<Department>> findAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @PostMapping
    ResponseEntity<Department> save(@RequestBody Department department) {
        return ResponseEntity.status(CREATED).body(departmentService.save(department));
    }

    @GetMapping("/{id}")
    ResponseEntity<Department> findById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @GetMapping("organization/{organizationId}")
    ResponseEntity<List<Department>> findByOrganization(@PathVariable Long organizationId) {
        return ResponseEntity.ok(departmentService.findByOrganization(organizationId));
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    ResponseEntity<List<Department>> findByOrganizationWithEmployees(@PathVariable Long organizationId) {
        return ResponseEntity.ok(departmentService.findByOrganizationWithEmployees(organizationId));
    }
}
