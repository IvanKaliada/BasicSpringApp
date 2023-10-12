package com.epam.ivankaliada.BasicSpringApp.service;

import com.epam.ivankaliada.BasicSpringApp.entity.Employee;
import com.epam.ivankaliada.BasicSpringApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public void saveConfigurations(Employee employee) {
        employeeRepository.save(employee);
    }

}
