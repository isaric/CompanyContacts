package edu.tvz.isaric.services.address.impl;

import edu.tvz.isaric.entities.Address;
import edu.tvz.isaric.repositories.AddressRepository;
import edu.tvz.isaric.services.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultAddressService implements AddressService
{

    private AddressRepository addressRepository;

    @Autowired
    public DefaultAddressService(AddressRepository addressRepository)
    {
        this.addressRepository = addressRepository;
    }

    @Override
    public void saveAddress(Address address)
    {
        addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Integer id)
    {
        return addressRepository.findOne(id);
    }
}
