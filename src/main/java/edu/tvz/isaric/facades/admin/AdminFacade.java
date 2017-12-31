package edu.tvz.isaric.facades.admin;

import edu.tvz.isaric.facades.data.CompanyData;
import edu.tvz.isaric.facades.data.DepartmentData;
import edu.tvz.isaric.facades.data.EmployeeData;
import edu.tvz.isaric.forms.DepartmentForm;

import java.util.List;

public interface AdminFacade
{
    List<DepartmentData> getDepartments();

    void createDepartment(DepartmentForm departmentForm);

    List<EmployeeData> getAllEmployees();

    DepartmentForm viewSingleDepartment(String uid);

    List<CompanyData> getAllCompanies();
}
