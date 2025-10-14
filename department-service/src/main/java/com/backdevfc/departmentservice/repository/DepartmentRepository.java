package com.backdevfc.departmentservice.repository;

import com.backdevfc.departmentservice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

  List<Department> findByOrganizationId(Long organizationId);
}
