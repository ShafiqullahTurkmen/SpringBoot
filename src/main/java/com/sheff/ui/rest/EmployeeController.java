package com.sheff.ui.rest;

import com.sheff.business.dto.EmployeeDto;
import com.sheff.business.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    //List
    // http://localhost:8080/api/vi/employees
    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeeDtosList = employeeServices.getAllEmployees();
        return employeeDtosList;
    }

    // FIND
    // http://localhost:8080/api/vi/employees/1
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "id") Long id) throws Throwable {
        EmployeeDto employeeDto = employeeServices.getEmployeeById(id).getBody();
        return ResponseEntity.ok(employeeDto);
    }

    // Save
    // http://localhost:8080/api/vi/employees
    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeServices.createEmployee(employeeDto);
        return employeeDto;
    }

    // Update
    // http://localhost:8080/api/vi/employees/1
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(name = "id") Long id,@RequestBody EmployeeDto employeeDto) throws Throwable {
        employeeServices.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(employeeDto);
    }

    // Delete
    // http://localhost:8080/api/vi/employees/1
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(name = "id") Long id) throws Throwable {
        employeeServices.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
