package edu.tvz.isaric.services.address;

import edu.tvz.isaric.entities.Address;

public interface AddressService
{
    void saveAddress(Address address);

    Address getAddressById(Integer id);
}
