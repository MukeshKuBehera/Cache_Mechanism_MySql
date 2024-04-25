package com.example.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;
@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private EmployeeRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		System.out.println("Data deleted Successfully");

		Employee e1 = new Employee();

		e1.setId(101);
		e1.setType("manager");
		Employee e2 = new Employee();
		e2.setId(102);
		e2.setType("Faculty");
		Employee e3 = new Employee();
		e3.setId(103);
		e3.setType("House-Keeper");
		Employee e4 = new Employee();
		e4.setId(104);
		e4.setType("Executive");

		List<Employee> emp = Arrays.asList(e1, e2, e3, e4);
		repo.saveAll(emp);

		System.out.println("Data Saved Successfully.....!");

	}

}
