package com.duycv.employee.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.duycv.employee.service.dto.DepartmentDTO;

@FeignClient(name = "department-service", fallback = DepartmentClientFallback.class)
public interface DepartmentClient {
	@GetMapping("/{departmentId}")
	public DepartmentDTO findById(@PathVariable("departmentId") Long departmentId);
}
