package com.duycv.employee.service.response;

import com.duycv.employee.service.dto.DepartmentDTO;
import com.duycv.employee.service.dto.OrganizationDTO;

public class EmployeeWithDepartmentAndOrganizationResponse {
	
	private Long id;
	private Long organizationId;
	private Long departmentId;
	private String name;
	private int age;
	private String position;
	private DepartmentDTO department;
	private OrganizationDTO organization;
	
	public EmployeeWithDepartmentAndOrganizationResponse() {
		
	}

	public EmployeeWithDepartmentAndOrganizationResponse(Long id, Long organizationId, Long departmentId, String name,
			int age, String position, DepartmentDTO departmentDTO, OrganizationDTO organizationDTO) {
		super();
		this.id = id;
		this.organizationId = organizationId;
		this.departmentId = departmentId;
		this.name = name;
		this.age = age;
		this.position = position;
		this.department = departmentDTO;
		this.organization = organizationDTO;
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

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO departmentDTO) {
		this.department = departmentDTO;
	}

	public OrganizationDTO getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationDTO organizationDTO) {
		this.organization = organizationDTO;
	}

	@Override
	public String toString() {
		return "EmployeeWithDepartmentAndOrganizationResponse [id=" + id + ", organizationId=" + organizationId
				+ ", departmentId=" + departmentId + ", name=" + name + ", age=" + age + ", position=" + position
				+ ", departmentDTO=" + department + ", organizationDTO=" + organization + "]";
	}
}
