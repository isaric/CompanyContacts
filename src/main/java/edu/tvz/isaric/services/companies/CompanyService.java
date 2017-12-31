package edu.tvz.isaric.services.companies;

import edu.tvz.isaric.entities.Client;
import edu.tvz.isaric.entities.Company;
import edu.tvz.isaric.entities.Employee;
import edu.tvz.isaric.entities.User;

import java.util.List;

public interface CompanyService
{
    boolean saveCompany(Company company);

    List<Company> getAllCompanies();

    Company getCompanyForContactPerson(Employee contactPerson);

    Company getCompanyForClient(Client client);

    List<Client> getClientsForCompany(Company company);

    List<Employee> getContactPersonsForCompany(Company company);

    Company getCompanyForUser(User user);
}
