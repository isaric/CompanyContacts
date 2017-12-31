package edu.tvz.isaric.services.departments.impl;

import edu.tvz.isaric.entities.Department;
import edu.tvz.isaric.repositories.DepartmentsRepository;
import edu.tvz.isaric.services.departments.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultDepartmentService implements DepartmentService
{
    private DepartmentsRepository departmentsRepository;

    @Autowired
    public DefaultDepartmentService(DepartmentsRepository departmentsRepository)
    {
        this.departmentsRepository = departmentsRepository;
    }

    @Override
    public List<Department> getAllDepartments()
    {
        return departmentsRepository.findAll();
    }

    @Override
    public void saveDepartment(Department department)
    {
        departmentsRepository.save(department);
    }

    @Override
    public Department getDepartmnetByUid(String uid)
    {
        return departmentsRepository.findOne(uid);
    }
}
