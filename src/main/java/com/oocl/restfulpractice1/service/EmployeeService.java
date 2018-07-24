package com.oocl.restfulpractice1.service;

import com.oocl.restfulpractice1.dao.EmployeeDao;
import com.oocl.restfulpractice1.domain.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Vito Zhuang on 7/24/2018.
 */
@Component
public class EmployeeService implements EmployeeDao {

    private Map<Integer,Employee> employees = new LinkedHashMap<>();
    private int id = 1;

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee deleteEmployee(int id) {
        return null;
    }

    @Override
    public Employee modifyEmployee(int id, Employee employee) {
        return null;
    }

    @Override
    public Employee searchEmployeeById(int id) {
        return null;
    }

}

