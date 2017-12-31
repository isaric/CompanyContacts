package edu.tvz.isaric.facades.converter;

import edu.tvz.isaric.entities.Address;
import edu.tvz.isaric.entities.Department;
import edu.tvz.isaric.facades.data.DepartmentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter
{

    private AddressConverter addressConverter;

    @Autowired
    public DepartmentConverter(AddressConverter addressConverter)
    {
        this.addressConverter = addressConverter;
    }

    public DepartmentData convert(Department source)
    {
        DepartmentData result = new DepartmentData();
        result.setUid(source.getUid());
        result.setName(source.getName());
        Address address = source.getAddress();
        if (address != null)
        {
            result.setAddress(addressConverter.convert(address));
        }
        return result;
    }
}
