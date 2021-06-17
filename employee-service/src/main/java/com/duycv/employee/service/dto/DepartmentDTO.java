package com.duycv.employee.service.dto;

public class DepartmentDTO {
	private Long id;
	private Long organizationId;
	private String name;

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

	@Override
	public String toString() {
		return "Department [id=" + id + ", organizationId=" + organizationId + ", name=" + name + "]";
	}
}
