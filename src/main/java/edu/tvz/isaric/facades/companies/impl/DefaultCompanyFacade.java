package edu.tvz.isaric.facades.companies.impl;

import edu.tvz.isaric.entities.*;
import edu.tvz.isaric.facades.companies.CompanyFacade;
import edu.tvz.isaric.facades.converter.ClientConverter;
import edu.tvz.isaric.facades.converter.CompanyConverter;
import edu.tvz.isaric.facades.converter.EmployeeConverter;
import edu.tvz.isaric.facades.data.ClientData;
import edu.tvz.isaric.facades.data.CompanyData;
import edu.tvz.isaric.facades.data.EmployeeData;
import edu.tvz.isaric.services.companies.CompanyService;
import edu.tvz.isaric.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultCompanyFacade implements CompanyFacade
{
    private CompanyService companyService;

    private CompanyConverter companyConverter;

    private UserService userService;

    private EmployeeConverter employeeConverter;

    private ClientConverter clientConverter;

    @Autowired
    public DefaultCompanyFacade(
            CompanyService companyService,
            CompanyConverter companyConverter,
            UserService userService,
            EmployeeConverter employeeConverter,
            ClientConverter clientConverter)
    {
        this.companyService = companyService;
        this.companyConverter = companyConverter;
        this.userService = userService;
        this.employeeConverter = employeeConverter;
        this.clientConverter = clientConverter;
    }

    @Override
    public List<ClientData> getClientsForCompany()
    {
        User user = userService.getCurrentUser();
        Company company = companyService.getCompanyForUser(user);
        List<Client> clients = company.getClients();
        return clients.stream().map(client -> clientConverter.convert(client)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeData> getEmployeesForCompany()
    {
        User user = userService.getCurrentUser();
        Company company = companyService.getCompanyForUser(user);
        List<Employee> employees = company.getContactPersons();
        return employees.stream().map(employee -> employeeConverter.convert(employee)).collect(Collectors.toList());
    }

    @Override
    public CompanyData getCompanyForUser()
    {
        User user = userService.getCurrentUser();
        Company company = companyService.getCompanyForUser(user);
        return companyConverter.convert(company);
    }
}
