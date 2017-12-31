package edu.tvz.isaric.facades.data;

public class ClientData extends UserData
{
    private CompanyData company;

    public CompanyData getCompany()
    {
        return company;
    }

    public void setCompany(CompanyData company)
    {
        this.company = company;
    }
}
