package com.duycv.organization.service.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duycv.organization.service.client.DepartmentClient;
import com.duycv.organization.service.client.EmployeeClient;
import com.duycv.organization.service.dto.OrganizationDTO;
import com.duycv.organization.service.model.Organization;
import com.duycv.organization.service.repository.OrganizationRepository;

@RestController
public class OrganizationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);
	
	@Autowired
	OrganizationRepository repository;
	@Autowired
	DepartmentClient departmentClient;
	@Autowired
	EmployeeClient employeeClient;
	@Autowired
    private ModelMapper modelMapper;
	
	@PostMapping
	public Organization add(@RequestBody Organization organization) {
		LOGGER.info("Organization add: {}", organization);
		return repository.save(organization);
	}
	
	@GetMapping
	public List<Organization> findAll() {
		LOGGER.info("Organization find");
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Organization findById(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		return repository.findById(id).get();
	}

	@GetMapping("/{id}/with-departments")
	public OrganizationDTO findByIdWithDepartments(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		Organization organization = repository.findById(id).get();
		OrganizationDTO organizationDTO = modelMapper.map(organization, OrganizationDTO.class);
		organizationDTO.setDepartments(departmentClient.findByOrganization(organizationDTO.getId()));
		return organizationDTO;
	}
	
	@GetMapping("/{id}/with-departments-and-employees")
	public OrganizationDTO findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		Organization organization = repository.findById(id).get();
		OrganizationDTO organizationDTO = modelMapper.map(organization, OrganizationDTO.class);
		organizationDTO.setDepartments(departmentClient.findByOrganizationWithEmployees(organizationDTO.getId()));
		return organizationDTO;
	}
	
	@GetMapping("/{id}/with-employees")
	public OrganizationDTO findByIdWithEmployees(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		Organization organization = repository.findById(id).get();
		OrganizationDTO organizationDTO = modelMapper.map(organization, OrganizationDTO.class);
		organizationDTO.setEmployees(employeeClient.findByOrganization(organizationDTO.getId()));
		return organizationDTO;
	}
}
