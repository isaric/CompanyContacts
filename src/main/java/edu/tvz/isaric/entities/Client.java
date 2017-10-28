package edu.tvz.isaric.entities;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client extends User
{
    @ManyToOne(targetEntity = Company.class)
    private Company company;

    @ManyToOne(targetEntity = Employee.class)
    private Employee contactPerson;

    @OneToOne(targetEntity = Address.class)
    private Address address;

    public Client()
    {
        setRole(Role.CLIENT);
    }

    public Company getCompany()
    {
        return company;
    }

    public void setCompany(Company company)
    {
        this.company = company;
    }

    public Employee getContactPerson()
    {
        return contactPerson;
    }

    public void setContactPerson(Employee contactPerson)
    {
        this.contactPerson = contactPerson;
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
