package edu.tvz.isaric.facades.converter;

import edu.tvz.isaric.entities.Company;
import edu.tvz.isaric.entities.Department;
import edu.tvz.isaric.entities.Employee;
import edu.tvz.isaric.facades.data.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter
{
    private UserConverter userConverter;

    private CompanyConverter companyConverter;

    private DepartmentConverter departmentConverter;

    @Autowired
    public EmployeeConverter(
            UserConverter userConverter,
            CompanyConverter companyConverter, DepartmentConverter departmentConverter)
    {
        this.userConverter = userConverter;
        this.companyConverter = companyConverter;
        this.departmentConverter = departmentConverter;
    }

    public EmployeeData convert(Employee source)
    {
        EmployeeData result = new EmployeeData();
        userConverter.convert(source, result);
        Department department = source.getDepartment();
        if (department != null)
        {
            result.setDepartment(departmentConverter.convert(department));
        }
        Company company = source.getAccount();
        if (company != null)
        {
            result.setAccount(companyConverter.convert(company));
        }
        return result;
    }
}
