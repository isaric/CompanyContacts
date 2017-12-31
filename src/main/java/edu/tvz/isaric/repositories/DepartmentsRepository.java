package edu.tvz.isaric.repositories;

import edu.tvz.isaric.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepository extends JpaRepository<Department, String>
{
}
