package com.backdevfc.employeeservice.service;

import com.backdevfc.employeeservice.model.Employee;
import com.backdevfc.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByDepartment(Long departmentId) {
        return employeeRepository.findAll()
                .stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .toList();
    }

    @Override
    public List<Employee> findByOrganization(Long organizationId) {
        return employeeRepository.findAll()
                .stream()
                .filter(employee -> employee.getOrganizationId().equals(organizationId))
                .toList();
    }
}
