package edu.tvz.isaric.facades.converter;

import edu.tvz.isaric.entities.Client;
import edu.tvz.isaric.entities.Company;
import edu.tvz.isaric.facades.data.ClientData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter
{

    private CompanyConverter companyConverter;

    private UserConverter userConverter;

    @Autowired
    public ClientConverter(
            CompanyConverter companyConverter,
            UserConverter userConverter)
    {
        this.companyConverter = companyConverter;
        this.userConverter = userConverter;
    }

    public ClientData convert(Client source)
    {
        ClientData result = new ClientData();
        userConverter.convert(source, result);
        Company company = source.getCompany();
        if (company != null)
        {
            result.setCompany(companyConverter.convert(company));
        }
        return result;
    }
}
