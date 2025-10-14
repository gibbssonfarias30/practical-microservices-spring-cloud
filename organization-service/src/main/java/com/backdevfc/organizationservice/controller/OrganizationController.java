package com.backdevfc.organizationservice.controller;


import com.backdevfc.organizationservice.model.Organization;
import com.backdevfc.organizationservice.service.IOrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/organizations")
@RestController
public class OrganizationController {

  private final IOrganizationService organizationService;

  @GetMapping
  ResponseEntity<List<Organization>> findAll() {
    return  ResponseEntity.ok(organizationService.findAll());
  }

  @GetMapping("/{id}")
  ResponseEntity<Organization> findById(@PathVariable Long id) {
    return ResponseEntity.ok(organizationService.findById(id));
  }

  @PostMapping
  ResponseEntity<Organization> save(@RequestBody Organization organization) {
    return ResponseEntity.status(CREATED).body(organizationService.save(organization));
  }

  @GetMapping("/{id}/with-departments-and-employees")
  ResponseEntity<Organization> findByIdWithDepartmentsAndEmployees(@PathVariable Long id) {
    return ResponseEntity.ok(organizationService.findByIdWithDepartmentsAndEmployees(id));
  }

  @GetMapping("/{id}/with-employees")
  ResponseEntity<Organization> findByIdWithEmployees(@PathVariable Long id) {
    return ResponseEntity.ok(organizationService.findByWithEmployees(id));
  }


}
