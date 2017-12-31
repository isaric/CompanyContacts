package edu.tvz.isaric.facades.converter;

import edu.tvz.isaric.entities.Address;
import edu.tvz.isaric.entities.Company;
import edu.tvz.isaric.facades.data.AddressData;
import edu.tvz.isaric.facades.data.CompanyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyConverter
{
    private AddressConverter addressConverter;

    @Autowired
    public CompanyConverter(
            AddressConverter addressConverter)
    {
        this.addressConverter = addressConverter;
    }

    public CompanyData convert(Company source)
    {
        CompanyData result = new CompanyData();
        result.setUid(source.getUid());
        result.setName(source.getName());
        Address companyAddress = source.getAddress();
        if (companyAddress != null)
        {
            AddressData companyAddressData = addressConverter.convert(companyAddress);
            result.setAddress(companyAddressData);
        }
        return result;
    }
}
