package com.duycv.organization.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.duycv.organization.service.dto.DepartmentDTO;

@FeignClient(name = "department-service", fallback = DepartmentClientFallback.class)
public interface DepartmentClient {
	@GetMapping("/organization/{organizationId}")
	public List<DepartmentDTO> findByOrganization(@PathVariable("organizationId") Long organizationId);
	
	@GetMapping("/organization/{organizationId}/with-employees")
	public List<DepartmentDTO> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId);
}
