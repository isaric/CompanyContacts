package edu.tvz.isaric.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CLIENT")
public class Client extends User
{
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

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
}
