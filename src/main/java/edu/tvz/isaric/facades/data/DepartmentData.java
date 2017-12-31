package edu.tvz.isaric.facades.data;

public class DepartmentData
{
    private String uid;

    private String name;

    private AddressData address;

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
}
