package com.duycv.department.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duycv.department.service.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	public List<Department> findByOrganizationId(Long organizationId);
}
