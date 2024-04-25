package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;

@Component
public class EmployemeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	@CachePut(cacheNames = "employee", key = "#employee.id")
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}

	@Override
	@Cacheable(value = "employee", key = "#id")
	public Optional<Employee> getEmployeeById(int id) {

		System.out.println("Get the Employee with the id :" + id);
		return employeeRepo.findById(id);
	}

	@Override
	@CachePut(cacheNames = "employee", key = "#employee.id")
	public Employee updateEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}

	@Override
	@CacheEvict(cacheNames = "employees", key = "#id")
	public void deleteEmployee(int id) {
		employeeRepo.deleteById(id);

	}

}
