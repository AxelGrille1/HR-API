package com.human_ressources.api.controller;

import com.human_ressources.api.model.Employee;
import com.human_ressources.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Create - Add an employee
     * @param employee An object employee
     * @return The employee object saved
     */
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }


    /**
     * Read - Get one employee
     * @param id The id of the employee
     * @return An Employee object fulfilled
     */
    @GetMapping("/employee/{id}")
    public Employee getEmployees(@PathVariable("id") final Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        if(employee.isPresent()) {
            return employee.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all employees
     * @return - An Iterable object of Employee fulfilled
     */
    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    /**
     * Update - Update an existing employee
     * @param id - The id of the employee to update
     * @param employee - The employee object updated
     * @return A modified existing employee
     */
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {
        Optional<Employee> e = employeeService.getEmployee(id);
        if(e.isPresent()) {
            Employee currentEmployee = e.get();

            String firstName = employee.getFirstName();
            if(firstName != null) {
                currentEmployee.setFirstName(firstName);
            }
            String lastName = employee.getLastName();
            if(lastName != null) {
                currentEmployee.setLastName(lastName);;
            }
            String mail = employee.getMail();
            if(mail != null) {
                currentEmployee.setMail(mail);
            }
            String password = employee.getPassword();
            if(password != null) {
                currentEmployee.setPassword(password);;
            }
            employeeService.saveEmployee(currentEmployee);
            return currentEmployee;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an employee
     * @param id - The id of the employee to delete
     */
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id) {
        employeeService.deleteEmployee(id);
    }

}
