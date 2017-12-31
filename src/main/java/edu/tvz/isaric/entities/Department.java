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

    @Column
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    @OneToOne(targetEntity = Employee.class)
    private Employee manager;

    @OneToOne(targetEntity = Address.class)
    @JoinColumn(name = "address")
    private Address address;

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
