package edu.tvz.isaric.services.departments;

import edu.tvz.isaric.entities.Department;

import java.util.List;

public interface DepartmentService
{
    List<Department> getAllDepartments();

    void saveDepartment(Department department);

    Department getDepartmnetByUid(String uid);
}
