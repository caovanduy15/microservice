package com.duycv.employee.service.client;

import org.springframework.stereotype.Component;

import com.duycv.employee.service.dto.DepartmentDTO;

@Component
public class DepartmentClientFallback implements DepartmentClient {

	@Override
	public DepartmentDTO findById(Long departmentId) {
		return null;
	}

}
