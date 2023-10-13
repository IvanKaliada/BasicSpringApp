package com.epam.ivankaliada.BasicSpringApp.service;

import com.epam.ivankaliada.BasicSpringApp.entity.Employee;
import com.epam.ivankaliada.BasicSpringApp.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@ActiveProfiles("dev")
@SpringBootTest
public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void shouldGetAllDbConfigurations() throws ParseException {
        //given
        Employee employee = new Employee();
        employee.setName("John");
        employee.setLastName("Smith");
        employee.setRole("Developer");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateOfBirth = "11/05/1999";
        employee.setDateOfBirth(simpleDateFormat.parse(dateOfBirth));
        //when
        employeeRepository.save(employee);
        //then
        Assertions.assertFalse(employeeService.getAllEmployees().isEmpty());
    }

}
