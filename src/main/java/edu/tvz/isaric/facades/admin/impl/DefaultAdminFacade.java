package edu.tvz.isaric.facades.admin.impl;

import edu.tvz.isaric.entities.Address;
import edu.tvz.isaric.entities.Department;
import edu.tvz.isaric.entities.Employee;
import edu.tvz.isaric.facades.admin.AdminFacade;
import edu.tvz.isaric.facades.converter.CompanyConverter;
import edu.tvz.isaric.facades.converter.DepartmentConverter;
import edu.tvz.isaric.facades.converter.DepartmentFormConverter;
import edu.tvz.isaric.facades.converter.EmployeeConverter;
import edu.tvz.isaric.facades.converter.reverse.AddressReverseConverter;
import edu.tvz.isaric.facades.converter.reverse.DepartmentFormReverseConverter;
import edu.tvz.isaric.facades.data.AddressData;
import edu.tvz.isaric.facades.data.CompanyData;
import edu.tvz.isaric.facades.data.DepartmentData;
import edu.tvz.isaric.facades.data.EmployeeData;
import edu.tvz.isaric.forms.DepartmentForm;
import edu.tvz.isaric.services.address.AddressService;
import edu.tvz.isaric.services.companies.CompanyService;
import edu.tvz.isaric.services.departments.DepartmentService;
import edu.tvz.isaric.services.employees.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultAdminFacade implements AdminFacade
{
    private DepartmentService departmentService;

    private DepartmentConverter departmentConverter;

    private DepartmentFormReverseConverter departmentFormReverseConverter;

    private DepartmentFormConverter departmentFormConverter;

    private EmployeeService employeeService;

    private EmployeeConverter employeeConverter;

    private CompanyService companyService;

    private CompanyConverter companyConverter;

    private AddressService addressService;

    private AddressReverseConverter addressReverseConverter;

    @Autowired
    public DefaultAdminFacade(
            DepartmentService departmentService,
            DepartmentConverter departmentConverter,
            DepartmentFormReverseConverter departmentFormReverseConverter,
            DepartmentFormConverter departmentFormConverter,
            EmployeeService employeeService,
            EmployeeConverter employeeConverter,
            CompanyService companyService,
            CompanyConverter companyConverter,
            AddressService addressService,
            AddressReverseConverter addressReverseConverter)
    {
        this.departmentService = departmentService;
        this.departmentConverter = departmentConverter;
        this.departmentFormReverseConverter = departmentFormReverseConverter;
        this.departmentFormConverter = departmentFormConverter;
        this.employeeService = employeeService;
        this.employeeConverter = employeeConverter;
        this.companyService = companyService;
        this.companyConverter = companyConverter;
        this.addressService = addressService;
        this.addressReverseConverter = addressReverseConverter;
    }

    @Override
    public List<DepartmentData> getDepartments()
    {
        List<Department> departments = departmentService.getAllDepartments();
        return departments.stream()
                          .map(department -> departmentConverter.convert(department))
                          .collect(Collectors.toList());
    }

    @Override
    public void createDepartment(DepartmentForm departmentForm)
    {
        Department department = departmentFormReverseConverter.convert(departmentForm);
        List<Employee> employees = departmentForm.getEmployees()
                                                 .stream()
                                                 .map(employeeData -> employeeService.findEmployeeByUid(employeeData.getUid()))
                                                 .collect(Collectors.toList());
        department.setEmployees(employees);
        EmployeeData managerData = departmentForm.getManager();
        if (managerData != null)
        {
            Employee manager = employeeService.findEmployeeByUid(managerData.getUid());
            department.setManager(manager);
        }
        Address address = department.getAddress();
        if (address != null)
        {
            addressService.saveAddress(address);
        }
        departmentService.saveDepartment(department);
    }

    @Override
    public List<EmployeeData> getAllEmployees()
    {
        List<Employee> employees = employeeService.findAll();
        return employees.stream()
                        .map(employee -> employeeConverter.convert(employee))
                        .collect(Collectors.toList());
    }

    @Override
    public DepartmentForm viewSingleDepartment(String uid)
    {
        Department department = departmentService.getDepartmnetByUid(uid);
        DepartmentForm form = departmentFormConverter.convert(department);
        return form;
    }

    @Override
    public List<CompanyData> getAllCompanies()
    {
        return companyService.getAllCompanies()
                             .stream()
                             .map(company -> companyConverter.convert(company))
                             .collect(Collectors.toList());
    }
}
