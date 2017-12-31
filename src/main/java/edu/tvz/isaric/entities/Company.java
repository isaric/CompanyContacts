package edu.tvz.isaric.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company
{
    @Id
    @Column
    private String uid;

    @Column
    private String name;

    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Client> clients;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Employee> contactPersons;

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

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public List<Client> getClients()
    {
        return clients;
    }

    public void setClients(List<Client> clients)
    {
        this.clients = clients;
    }

    public List<Employee> getContactPersons()
    {
        return contactPersons;
    }

    public void setContactPersons(List<Employee> contactPersons)
    {
        this.contactPersons = contactPersons;
    }
}
