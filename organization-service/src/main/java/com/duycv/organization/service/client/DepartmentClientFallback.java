package com.duycv.organization.service.client;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duycv.organization.service.dto.DepartmentDTO;

@Component
public class DepartmentClientFallback implements DepartmentClient {

	@Override
	public List<DepartmentDTO> findByOrganization(Long organizationId) {
		return Collections.emptyList();
	}

	@Override
	public List<DepartmentDTO> findByOrganizationWithEmployees(Long organizationId) {
		return Collections.emptyList();
	}

}
