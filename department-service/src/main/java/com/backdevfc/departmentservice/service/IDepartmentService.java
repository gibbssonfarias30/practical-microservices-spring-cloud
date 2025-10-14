package com.backdevfc.departmentservice.service;

import com.backdevfc.departmentservice.model.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll();
    Department findById(Long id);
    Department save(Department department);
    List<Department> findByOrganization(Long organizationId);
    List<Department> findByOrganizationWithEmployees(Long organizationId);
}
