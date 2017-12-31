package edu.tvz.isaric.facades.converter.reverse;

import edu.tvz.isaric.entities.Address;
import edu.tvz.isaric.facades.data.AddressData;
import org.springframework.stereotype.Component;

@Component
public class AddressReverseConverter
{
    public Address convert(AddressData addressData)
    {
        Address result = new Address();
        result.setPhoneNumber(addressData.getPhoneNumber());
        result.setCountry(addressData.getCountry());
        result.setStreet(addressData.getStreet());
        result.setCity(addressData.getCity());
        result.setId(addressData.getId());
        return result;
    }
}
