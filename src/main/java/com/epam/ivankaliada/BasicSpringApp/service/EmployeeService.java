package com.epam.ivankaliada.BasicSpringApp.service;

import com.epam.ivankaliada.BasicSpringApp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> getAllEmployees();

}
