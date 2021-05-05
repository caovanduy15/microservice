package com.duycv.department.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.duycv.department.service.dto.EmployeeDTO;

@FeignClient(name = "employee-service")
public interface EmployeeClient {
	
	@GetMapping("/department/{departmentId}")
	List<EmployeeDTO> findByDepartment(@PathVariable("departmentId") Long departmentId);
}
