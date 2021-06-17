package com.duycv.employee.service.client;

import org.springframework.stereotype.Component;

import com.duycv.employee.service.dto.OrganizationDTO;

@Component
public class OrganizationClientFallback implements OrganizationClient {

	@Override
	public OrganizationDTO findById(Long organizationId) {
		return null;
	}

}
