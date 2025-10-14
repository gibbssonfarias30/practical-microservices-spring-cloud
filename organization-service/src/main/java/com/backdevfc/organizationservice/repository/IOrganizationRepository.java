package com.backdevfc.organizationservice.repository;

import com.backdevfc.organizationservice.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrganizationRepository extends JpaRepository<Organization, Long> {

}
