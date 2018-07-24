package com.oocl.restfulpractice1.controller;

import com.alibaba.fastjson.JSONObject;
import com.oocl.restfulpractice1.domain.Employee;
import com.oocl.restfulpractice1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/employee/{employeeId}")
    public JSONObject deleteEmployee(@PathVariable int employeeId){
        JSONObject response = new JSONObject();
        Employee employee = employeeService.deleteEmployee(employeeId);
        if(employee!=null){
            response.put("employee",employee);
            response.put("message","delete successfully");
        }
        else{
            response.put("message","delete failed");
        }
        return response;
    }

    @PutMapping("/employee/{employeeId}")
    public JSONObject modifyEmployee(@PathVariable int employeeId,
                                             @RequestBody Employee employee){
        JSONObject response = new JSONObject();
        Employee newEmployee = employeeService.modifyEmployee(employeeId,employee);
        if(newEmployee!=null) {
            response.put("employee", newEmployee);
            response.put("message", "modify successfully");
        }
        else{
            response.put("message","modify failed");
        }
        return response;
    }
}
