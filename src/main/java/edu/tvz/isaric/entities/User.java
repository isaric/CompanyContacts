package edu.tvz.isaric.entities;

import javax.persistence.*;

@Entity
public class User
{
    @Id
    @Column(nullable = false)
    private String uid;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String passwordHash;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }

    public Role getRole()
    {
        return role;
    }

    protected void setRole(Role role)
    {
        this.role = role;
    }
}
