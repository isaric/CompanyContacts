package edu.tvz.isaric.facades.converter;

import edu.tvz.isaric.entities.Address;
import edu.tvz.isaric.facades.data.AddressData;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter
{
    public AddressData convert(Address source)
    {
        AddressData result = new AddressData();
        result.setStreet(source.getStreet());
        result.setCity(source.getCity());
        result.setCountry(source.getCountry());
        result.setPhoneNumber(source.getPhoneNumber());
        result.setId(source.getId());
        return result;
    }
}
