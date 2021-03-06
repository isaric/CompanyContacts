package edu.tvz.isaric.services.employees;

import edu.tvz.isaric.entities.Employee;
import edu.tvz.isaric.forms.EmployeeForm;

import java.util.List;

public interface EmployeeService
{
    Employee findEmployeeByUid(String uid);

    void createEmployee(EmployeeForm employee);

    void updateEmployee(EmployeeForm employee);

    void deleteEmployee(String uid);

    List<Employee> findAll();
}
