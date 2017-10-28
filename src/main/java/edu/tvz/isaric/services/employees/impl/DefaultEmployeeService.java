package edu.tvz.isaric.services.employees.impl;

import edu.tvz.isaric.entities.Employee;
import edu.tvz.isaric.forms.EmployeeForm;
import edu.tvz.isaric.repositories.EmployeeRepository;
import edu.tvz.isaric.services.employees.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultEmployeeService implements EmployeeService
{
    private EmployeeRepository employeeRepository;

    @Autowired
    public DefaultEmployeeService(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findEmployeeByUid(String uid)
    {
        return employeeRepository.findByUid(uid);
    }

    @Override
    public void createEmployee(EmployeeForm employee)
    {
        Employee newEmployee = new Employee();
        newEmployee.setUid(employee.getUid());
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        employeeRepository.save(newEmployee);
    }

    @Override
    public void updateEmployee(EmployeeForm employee)
    {
        Employee toUpdate = employeeRepository.findByUid(employee.getUid());
        toUpdate.setFirstName(employee.getFirstName());
        toUpdate.setLastName(employee.getLastName());
        employeeRepository.save(toUpdate);
    }

    @Override
    public void deleteEmployee(String uid)
    {
        employeeRepository.deleteByUid(uid);
    }
}
