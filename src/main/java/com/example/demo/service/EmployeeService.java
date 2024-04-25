package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

@Service
public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	Optional<Employee> getEmployeeById(int id);

	Employee updateEmployee(Employee employee);

	void deleteEmployee(int id);

}
