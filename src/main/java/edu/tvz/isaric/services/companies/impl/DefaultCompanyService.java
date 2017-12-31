package edu.tvz.isaric.services.companies.impl;

import edu.tvz.isaric.entities.Client;
import edu.tvz.isaric.entities.Company;
import edu.tvz.isaric.entities.Employee;
import edu.tvz.isaric.entities.User;
import edu.tvz.isaric.repositories.CompanyRepository;
import edu.tvz.isaric.services.companies.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCompanyService implements CompanyService
{
    private CompanyRepository companyRepository;

    @Autowired
    public DefaultCompanyService(CompanyRepository companyRepository)
    {
        this.companyRepository = companyRepository;
    }

    @Override
    public boolean saveCompany(Company company)
    {
        return company.getUid() != null && persistCompany(company);
    }

    private boolean persistCompany(Company company)
    {
        boolean result = true;
        try
        {
            companyRepository.save(company);
        }
        catch (Exception ex)
        {
            result = false;
        }
        return result;
    }

    @Override
    public List<Company> getAllCompanies()
    {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyForContactPerson(Employee contactPerson)
    {
        return companyRepository.getCompanyByContactPersons(contactPerson);
    }

    @Override
    public Company getCompanyForClient(Client client)
    {
        return companyRepository.getCompanyByClients(client);
    }

    @Override
    public List<Client> getClientsForCompany(Company company)
    {
        return company.getClients();
    }

    @Override
    public List<Employee> getContactPersonsForCompany(Company company)
    {
        return company.getContactPersons();
    }

    @Override
    public Company getCompanyForUser(User user)
    {
        Company company = null;
        if (user instanceof Employee)
        {
            company = this.getCompanyForContactPerson((Employee) user);
        }
        else if (user instanceof Client)
        {
            company = this.getCompanyForClient((Client) user);
        }
        return company;
    }
}
