package com.backdevfc.employeeservice.controller;

import com.backdevfc.employeeservice.model.Employee;
import com.backdevfc.employeeservice.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/employees")
@RestController
public class EmployeeController {

  private final IEmployeeService employeeService;

  @GetMapping
  ResponseEntity<List<Employee>> findAll() {
    log.debug("REST request to find all employees");
    return ResponseEntity.ok(employeeService.findAll());
  }

  @GetMapping("/{id}")
  ResponseEntity<Employee> findById(@PathVariable Long id) {
    log.info("Find employee by id {}", id);
    return ResponseEntity.ok(employeeService.findById(id));
  }

  @PostMapping
  ResponseEntity<Employee> save(@RequestBody Employee employee) {
    log.info("save employee : {}", employee);
    return ResponseEntity.ok(employeeService.save(employee));
  }

  @GetMapping("/department/{departmentId}")
  ResponseEntity<List<Employee>> findByDepartment(@PathVariable Long departmentId) {
    log.info("employee find: departmentId: {}", departmentId);
    return ResponseEntity.ok(employeeService.findByDepartment(departmentId));
  }

  @GetMapping("/organization/{organizationId}")
  ResponseEntity<List<Employee>> findByOrganization(@PathVariable Long organizationId) {
    log.info("employee find: organizationId: {}", organizationId);
    return ResponseEntity.ok(employeeService.findByOrganization(organizationId));
  }
}
