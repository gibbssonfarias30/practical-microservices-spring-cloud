package com.backdevfc.organizationservice.service;


import com.backdevfc.organizationservice.client.DepartmentClient;
import com.backdevfc.organizationservice.client.EmployeeClient;
import com.backdevfc.organizationservice.model.Organization;
import com.backdevfc.organizationservice.repository.IOrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrganizationServiceImpl implements IOrganizationService {

    private final IOrganizationRepository organizationRepository;
    private final DepartmentClient departmentClient;
    private final EmployeeClient employeeClient;

    @Override
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization findById(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    @Override
    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public Organization findByIdWithDepartmentsAndEmployees(Long id) {
        Organization organization = organizationRepository.findById(id).orElse(null);
        assert organization != null;
        organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
        return organization;
    }

    @Override
    public Organization findByWithEmployees(Long id) {
        Organization organization = organizationRepository.findById(id).orElse(null);
        assert organization != null;
        organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
        return organization;
    }
}
