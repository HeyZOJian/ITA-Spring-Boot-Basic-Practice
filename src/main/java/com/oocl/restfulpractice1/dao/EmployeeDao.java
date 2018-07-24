package com.oocl.restfulpractice1.dao;


import com.oocl.restfulpractice1.domain.Employee;

import java.util.List;

public interface EmployeeDao{
    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);
    Employee deleteEmployee(int id);
    Employee modifyEmployee(int id,Employee employee);
    Employee searchEmployeeById(int id);
}