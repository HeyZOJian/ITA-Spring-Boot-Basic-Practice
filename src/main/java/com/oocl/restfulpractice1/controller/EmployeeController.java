package com.oocl.restfulpractice1.controller;

import com.alibaba.fastjson.JSONObject;
import com.oocl.restfulpractice1.domain.Employee;
import com.oocl.restfulpractice1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employee")
    public JSONObject addEmployee(@RequestBody Employee employee){
        JSONObject response = new JSONObject();
        employee = employeeService.addEmployee(employee);
        if(employee!=null){
            response.put("employee",employee);
            response.put("message","add employee successfully");
        }
        else{
            response.put("message","add employee failed");
        }
        return response;
    }
}
