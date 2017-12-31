package edu.tvz.isaric.facades.companies;

import edu.tvz.isaric.facades.data.ClientData;
import edu.tvz.isaric.facades.data.CompanyData;
import edu.tvz.isaric.facades.data.EmployeeData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CompanyFacade
{
    List<ClientData> getClientsForCompany();

    List<EmployeeData> getEmployeesForCompany();

    CompanyData getCompanyForUser();
}
