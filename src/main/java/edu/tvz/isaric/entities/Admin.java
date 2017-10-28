package edu.tvz.isaric.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Admin extends Employee
{
    public Admin()
    {
        setRole(Role.ADMIN);
    }
}
