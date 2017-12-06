package edu.tvz.isaric.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee extends User
{
    @ManyToOne(targetEntity = Department.class)
    private Department department;

    @Column
    private Double monthlySalary;

    @Column
    private Double hoursWorked;

    @Column
    private boolean sick;

    @Column
    private boolean vacation;

    @OneToOne(targetEntity = Address.class)
    private Address homeAddress;

    @OneToOne(targetEntity = Address.class)
    private Address workAddress;

    @OneToMany(mappedBy = "contactPerson")
    private List<Client> clients;

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

    public Double getMonthlySalary()
    {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary)
    {
        this.monthlySalary = monthlySalary;
    }

    public Double getHoursWorked()
    {
        return hoursWorked;
    }

    public void setHoursWorked(Double hoursWorked)
    {
        this.hoursWorked = hoursWorked;
    }

    public boolean isSick()
    {
        return sick;
    }

    public void setSick(boolean sick)
    {
        this.sick = sick;
    }

    public boolean isVacation()
    {
        return vacation;
    }

    public void setVacation(boolean vacation)
    {
        this.vacation = vacation;
    }

    public Address getHomeAddress()
    {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress)
    {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress()
    {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress)
    {
        this.workAddress = workAddress;
    }

    public List<Client> getClients()
    {
        return clients;
    }

    public void setClients(List<Client> clients)
    {
        this.clients = clients;
    }
}
