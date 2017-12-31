package edu.tvz.isaric.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends User
{
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company account;

    public Employee()
    {
        setRole(Role.EMPLOYEE);
    }

    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    public Company getAccount()
    {
        return account;
    }

    public void setAccount(Company account)
    {
        this.account = account;
    }
}
