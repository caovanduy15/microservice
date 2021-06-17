package com.duycv.employee.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.duycv.employee.service.dto.OrganizationDTO;

@FeignClient(name = "organization-service", fallback = OrganizationClientFallback.class)
public interface OrganizationClient {
	@GetMapping("/{organizationId}")
	public OrganizationDTO findById(@PathVariable("organizationId") Long organizationId);
}
