package com.duycv.organization.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.duycv.organization.service.dto.EmployeeDTO;

@FeignClient(name = "employee-service")
public interface EmployeeClient {
	
	@GetMapping("/organization/{organizationId}")
	List<EmployeeDTO> findByOrganization(@PathVariable("organizationId") Long organizationId);
}
