package edu.tvz.isaric.facades.converter.reverse;

import edu.tvz.isaric.entities.Department;
import edu.tvz.isaric.forms.DepartmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentFormReverseConverter
{
    private AddressReverseConverter addressReverseConverter;

    @Autowired
    public DepartmentFormReverseConverter(AddressReverseConverter addressReverseConverter)
    {
        this.addressReverseConverter = addressReverseConverter;
    }

    public Department convert(DepartmentForm departmentForm)
    {
        Department result = new Department();
        if (departmentForm.getAddress() != null)
        {
            result.setAddress(addressReverseConverter.convert(departmentForm.getAddress()));
        }
        result.setName(departmentForm.getName());
        result.setUid(departmentForm.getUid());
        return result;
    }
}
