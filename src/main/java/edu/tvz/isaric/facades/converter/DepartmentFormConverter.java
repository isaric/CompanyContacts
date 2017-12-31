package edu.tvz.isaric.facades.converter;

import edu.tvz.isaric.entities.Department;
import edu.tvz.isaric.entities.Employee;
import edu.tvz.isaric.forms.DepartmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentFormConverter
{
    private EmployeeConverter employeeConverter;

    @Autowired
    public DepartmentFormConverter(EmployeeConverter employeeConverter)
    {
        this.employeeConverter = employeeConverter;
    }

    public DepartmentForm convert(Department source)
    {
        DepartmentForm result = new DepartmentForm();
        result.setUid(source.getUid());
        result.setName(source.getName());
        Employee manager = source.getManager();
        if (manager != null)
        {
            result.setManager(employeeConverter.convert(manager));
        }
        List<Employee> employees = source.getEmployees();
        if (employees != null)
        {
            result.setEmployees(employees.stream().map(employee -> employeeConverter.convert(employee)).collect(
                    Collectors.toList()));
        }
        return result;
    }
}
