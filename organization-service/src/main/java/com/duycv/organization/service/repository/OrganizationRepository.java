package com.duycv.organization.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duycv.organization.service.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	
}
