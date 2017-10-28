package edu.tvz.isaric.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department
{
    @Id
    @Column
    private String uid;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    @OneToOne(targetEntity = Employee.class)
    private Employee manager;

    @OneToOne(targetEntity = Address.class)
    private Address address;

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public List<Employee> getEmployees()
    {
        return employees;
    }

    public void setEmployees(List<Employee> employees)
    {
        this.employees = employees;
    }

    public Employee getManager()
    {
        return manager;
    }

    public void setManager(Employee manager)
    {
        this.manager = manager;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }
}
