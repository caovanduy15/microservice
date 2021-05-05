package com.duycv.department.service.dto;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDTO {
	
	private Long id;
	private Long organizationId;
	private String name;
	private List<EmployeeDTO> employees = new ArrayList<>();

	public DepartmentDTO() {
		
	}

	public DepartmentDTO(Long organizationId, String name) {
		super();
		this.organizationId = organizationId;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeeDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDTO> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", organizationId=" + organizationId + ", name=" + name + "]";
	}
}
