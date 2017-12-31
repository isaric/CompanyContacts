package edu.tvz.isaric.forms;

import edu.tvz.isaric.facades.data.AddressData;
import edu.tvz.isaric.facades.data.EmployeeData;

import java.util.List;

public class DepartmentForm
{
    private String uid;

    private String name;

    private AddressData address;

    private EmployeeData manager;

    private List<EmployeeData> employees;

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public AddressData getAddress()
    {
        return address;
    }

    public void setAddress(AddressData address)
    {
        this.address = address;
    }

    public EmployeeData getManager()
    {
        return manager;
    }

    public void setManager(EmployeeData manager)
    {
        this.manager = manager;
    }

    public List<EmployeeData> getEmployees()
    {
        return employees;
    }

    public void setEmployees(List<EmployeeData> employees)
    {
        this.employees = employees;
    }
}
