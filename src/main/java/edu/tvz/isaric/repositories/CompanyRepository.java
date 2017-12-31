package edu.tvz.isaric.repositories;

import edu.tvz.isaric.entities.Client;
import edu.tvz.isaric.entities.Company;
import edu.tvz.isaric.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String>
{
    Company getCompanyByUid(String uid);

    Company getCompanyByContactPersons(Employee employee);

    Company getCompanyByClients(Client client);
}
