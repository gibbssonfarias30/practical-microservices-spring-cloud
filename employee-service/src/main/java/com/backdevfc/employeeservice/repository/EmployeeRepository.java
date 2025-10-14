package com.backdevfc.employeeservice.repository;

import com.backdevfc.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
