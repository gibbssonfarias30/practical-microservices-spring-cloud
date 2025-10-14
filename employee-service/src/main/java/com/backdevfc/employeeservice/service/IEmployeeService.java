package com.backdevfc.employeeservice.service;

import com.backdevfc.employeeservice.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee findById(Long id);
    Employee save(Employee employee);
    List<Employee> findByDepartment(Long departmentId);
    List<Employee> findByOrganization(Long organizationId);
}
