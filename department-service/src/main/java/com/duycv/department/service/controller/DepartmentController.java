package com.duycv.department.service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duycv.department.service.client.EmployeeClient;
import com.duycv.department.service.dto.DepartmentDTO;
import com.duycv.department.service.model.Department;
import com.duycv.department.service.repository.DepartmentRepository;

@RestController
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	DepartmentRepository repository;
	
	@Autowired
	EmployeeClient employeeClient;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@PostMapping("/")
	public Department add(@RequestBody Department department) {
		LOGGER.info("Department add: {}", department);
		return repository.save(department);
	}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable("id") Long id) {
		LOGGER.info("Department find: id={}", id);
		return repository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		LOGGER.info("Department delete: id={}", id);
		repository.deleteById(id);
	}
	
	@GetMapping("/{id}/with-employees")
	public DepartmentDTO findByIdWithEmployees(@PathVariable("id") Long id) {
		LOGGER.info("Department find: id={}", id);
		Department department = repository.findById(id).get();
		DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
		departmentDTO.setEmployees(employeeClient.findByDepartment(departmentDTO.getId()));
		return departmentDTO;
	}
	
	@GetMapping("/")
	public List<Department> findAll() {
		LOGGER.info("Department find");
		return repository.findAll();
	}
	
	@GetMapping("/organization/{organizationId}")
	public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Department find: organizationId={}", organizationId);
		return repository.findByOrganizationId(organizationId);
	}
	
	@GetMapping("/organization/{organizationId}/with-employees")
	public List<DepartmentDTO> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Department find: organizationId={}", organizationId);
		List<Department> departments = repository.findByOrganizationId(organizationId);
		List<DepartmentDTO> departmentDTOs = departments
				  .stream()
				  .map(d -> modelMapper.map(d, DepartmentDTO.class))
				  .collect(Collectors.toList());
		departmentDTOs.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId())));
		return departmentDTOs;
	}
}
