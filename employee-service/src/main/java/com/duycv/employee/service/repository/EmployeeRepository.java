package com.duycv.employee.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duycv.employee.service.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public List<Employee> findByDepartmentId(Long departmentId);
	
	public List<Employee> findByOrganizationId(Long organizationId);
}
