package edu.tvz.isaric.repositories;

import edu.tvz.isaric.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer>
{
}
