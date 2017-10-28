package edu.tvz.isaric.controllers;

import edu.tvz.isaric.entities.Employee;
import edu.tvz.isaric.forms.EmployeeForm;
import edu.tvz.isaric.services.employees.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employees")
public class EmployeeController
{
    private EmployeeService defaultEmployeeService;

    @Autowired
    public EmployeeController(EmployeeService defaultEmployeeService)
    {
        this.defaultEmployeeService = defaultEmployeeService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Employee addEmployee(@RequestBody EmployeeForm employeeForm)
    {
        defaultEmployeeService.createEmployee(employeeForm);
        return defaultEmployeeService.findEmployeeByUid(employeeForm.getUid());
    }
}
