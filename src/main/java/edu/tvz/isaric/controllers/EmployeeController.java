package edu.tvz.isaric.controllers;

import edu.tvz.isaric.entities.Employee;
import edu.tvz.isaric.forms.EmployeeForm;
import edu.tvz.isaric.services.employees.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController
{
    private EmployeeService defaultEmployeeService;

    @Autowired
    public EmployeeController(EmployeeService defaultEmployeeService)
    {
        this.defaultEmployeeService = defaultEmployeeService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Employee addEmployee(
            @RequestBody
                    EmployeeForm employeeForm)
    {
        defaultEmployeeService.createEmployee(employeeForm);
        return defaultEmployeeService.findEmployeeByUid(employeeForm.getUid());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getEmployees()
    {
        return defaultEmployeeService.findAll();
    }

    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public Employee getEmployee(
            @PathVariable(name = "uid", required = false)
                    String uid)
    {
        if (uid != null)
        { return defaultEmployeeService.findEmployeeByUid(uid); }
        else
        { return null; }
    }
}
