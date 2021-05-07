package com.duycv.department.service.client;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duycv.department.service.dto.EmployeeDTO;

@Component
public class EmployeeClientFallback implements EmployeeClient {

	@Override
	public List<EmployeeDTO> findByDepartment(Long departmentId) {
		return Collections.emptyList();
	}

}
