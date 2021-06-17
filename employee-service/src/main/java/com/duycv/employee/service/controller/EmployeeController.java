package com.duycv.employee.service.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duycv.employee.service.client.DepartmentClient;
import com.duycv.employee.service.client.OrganizationClient;
import com.duycv.employee.service.model.Employee;
import com.duycv.employee.service.repository.EmployeeRepository;
import com.duycv.employee.service.response.EmployeeWithDepartmentAndOrganizationResponse;

@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeRepository repository;
	@Autowired
	DepartmentClient departmentClient;
	@Autowired
	OrganizationClient organizationClient;
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	Environment environment;
	
	@GetMapping("/hello")
	public String hello() {
		return "Employee service\n" + 
				"Port: " + environment.getProperty("server.port");
	}
	
	@PostMapping("/")
	public Employee add(@RequestBody Employee employee) {
		LOGGER.info("Employee add: {}", employee);
		return repository.save(employee);
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") Long id) {
		LOGGER.info("Employee find: id={}", id);
		try {
			return repository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		LOGGER.info("Employee delete: id={}", id);
		repository.deleteById(id);
	}
	
	@GetMapping("/{id}/with-department-and-organization")
	public EmployeeWithDepartmentAndOrganizationResponse findByIdWithDepartmentAndOrganization(@PathVariable("id") Long id) {
		LOGGER.info("Employee find: id={}", id);
		Employee employee = repository.findById(id).get();
		EmployeeWithDepartmentAndOrganizationResponse employeeWithDepartmentAndOrganizationResponse = modelMapper.map(employee, EmployeeWithDepartmentAndOrganizationResponse.class);
		employeeWithDepartmentAndOrganizationResponse.setDepartment(departmentClient.findById(employeeWithDepartmentAndOrganizationResponse.getDepartmentId()));
		employeeWithDepartmentAndOrganizationResponse.setOrganization(organizationClient.findById(employeeWithDepartmentAndOrganizationResponse.getOrganizationId()));
		return employeeWithDepartmentAndOrganizationResponse;
	}
	
	@GetMapping("/")
	public List<Employee> findAll() {
		LOGGER.info("Employee find");
		return repository.findAll();
	}
	
	@GetMapping("/department/{departmentId}")
	public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
		LOGGER.info("Employee find: departmentId={}", departmentId);
		return repository.findByDepartmentId(departmentId);
	}
	
	@GetMapping("/organization/{organizationId}")
	public List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Employee find: organizationId={}", organizationId);
		return repository.findByOrganizationId(organizationId);
	}
}
