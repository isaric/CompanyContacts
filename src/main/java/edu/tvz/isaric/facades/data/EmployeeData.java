package edu.tvz.isaric.facades.data;

public class EmployeeData extends UserData
{
    private DepartmentData department;

    private CompanyData account;

    public DepartmentData getDepartment()
    {
        return department;
    }

    public void setDepartment(DepartmentData department)
    {
        this.department = department;
    }

    public CompanyData getAccount()
    {
        return account;
    }

    public void setAccount(CompanyData account)
    {
        this.account = account;
    }
}
