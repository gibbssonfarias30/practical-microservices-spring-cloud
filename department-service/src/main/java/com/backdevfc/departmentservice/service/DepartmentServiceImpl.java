package com.backdevfc.departmentservice.service;

import com.backdevfc.departmentservice.client.EmployeeClient;
import com.backdevfc.departmentservice.model.Department;
import com.backdevfc.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> findByOrganization(Long organizationId) {
        return departmentRepository.findByOrganizationId(organizationId);
    }

    @Override
    public List<Department> findByOrganizationWithEmployees(Long organizationId) {
        List<Department> departments = findByOrganization(organizationId);
        departments.forEach(department -> department.setEmployees(employeeClient.findByDepartment(department.getId())));
        return departments;
    }
}
