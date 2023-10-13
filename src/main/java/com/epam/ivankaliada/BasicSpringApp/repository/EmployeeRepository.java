package com.epam.ivankaliada.BasicSpringApp.repository;

import com.epam.ivankaliada.BasicSpringApp.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
