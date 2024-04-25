package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployemeeServiceImpl;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployemeeServiceImpl employemeeServiceImpl;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employemeeServiceImpl.saveEmployee(employee);
		return ResponseEntity.ok(savedEmployee);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
		Optional<Employee> employee = employemeeServiceImpl.getEmployeeById(id);

		if (employee.isPresent()) {
			return ResponseEntity.ok(employee.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		employee.setId(id); // Set the ID from the path variable
		Employee updatedEmployee = employemeeServiceImpl.updateEmployee(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
		employemeeServiceImpl.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
}
