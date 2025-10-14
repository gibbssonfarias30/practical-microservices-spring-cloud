package com.backdevfc.organizationservice.service;

import com.backdevfc.organizationservice.model.Organization;

import java.util.List;

public interface IOrganizationService {

    List<Organization> findAll();
    Organization findById(Long id);
    Organization save(Organization organization);

    Organization findByIdWithDepartmentsAndEmployees(Long id);
    Organization findByWithEmployees(Long id);
}
