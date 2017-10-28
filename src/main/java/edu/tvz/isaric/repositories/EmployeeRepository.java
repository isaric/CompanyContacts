package edu.tvz.isaric.repositories;

import edu.tvz.isaric.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>
{
    Employee findByUid(String uid);

    void deleteByUid(String uid);
}
