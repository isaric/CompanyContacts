package edu.tvz.isaric.controllers;

import edu.tvz.isaric.facades.companies.CompanyFacade;
import edu.tvz.isaric.facades.data.ClientData;
import edu.tvz.isaric.facades.data.CompanyData;
import edu.tvz.isaric.facades.data.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompaniesController
{
    private CompanyFacade companyFacade;

    @Autowired
    public CompaniesController(CompanyFacade companyFacade)
    {
        this.companyFacade = companyFacade;
    }

    @RequestMapping(method = RequestMethod.GET)
    public CompanyData getCompany()
    {
        return companyFacade.getCompanyForUser();
    }

    @RequestMapping(value = "/contactPersons", method = RequestMethod.GET)
    public List<EmployeeData> getContactPersonsForCompany()
    {
        return companyFacade.getEmployeesForCompany();
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<ClientData> getClientsForCompany()
    {
        return companyFacade.getClientsForCompany();
    }
}
