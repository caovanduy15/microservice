package com.duycv.organization.service.client;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duycv.organization.service.dto.EmployeeDTO;

@Component
public class EmployeeClientFallback implements EmployeeClient {

	@Override
	public List<EmployeeDTO> findByOrganization(Long organizationId) {
		return Collections.emptyList();
	}

}
