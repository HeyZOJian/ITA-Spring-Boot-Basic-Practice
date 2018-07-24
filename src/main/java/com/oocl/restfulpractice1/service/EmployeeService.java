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
        try{
            employee.setId(id);
            employees.put(id,employee);
            id++;
            return employee;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Employee deleteEmployee(int id) {
        try {
            return employees.remove(id);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Employee modifyEmployee(int id,Employee employee) {
        try {
            Employee oldEmployee = employees.get(id);
            Employee newEmployee = new Employee();
            newEmployee.setId(id);
            newEmployee.setName(employee.getName()!=null?employee.getName():oldEmployee.getName());
            newEmployee.setAge(employee.getAge()!=0?employee.getAge():oldEmployee.getAge());
            newEmployee.setGender(employee.getGender()!=null?employee.getGender():oldEmployee.getGender());
            employees.put(id,newEmployee);
            return employees.get(id);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Employee searchEmployeeById(int id) {
        return null;
    }

}

