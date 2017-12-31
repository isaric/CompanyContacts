package edu.tvz.isaric.controllers;

import edu.tvz.isaric.facades.admin.AdminFacade;
import edu.tvz.isaric.facades.data.CompanyData;
import edu.tvz.isaric.facades.data.DepartmentData;
import edu.tvz.isaric.facades.data.EmployeeData;
import edu.tvz.isaric.forms.DepartmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController
{
    private AdminFacade adminFacade;

    @Autowired
    public AdminController(AdminFacade adminFacade)
    {
        this.adminFacade = adminFacade;
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public List<DepartmentData> getDepartments()
    {
        return adminFacade.getDepartments();
    }

    @RequestMapping(value = "/departments/{uid}", method = RequestMethod.GET)
    public DepartmentForm viewSingleDepartment(
            @PathVariable(name = "uid")
                    String uid)
    {
        return adminFacade.viewSingleDepartment(uid);
    }

    @RequestMapping(value = "/departments/create", method = RequestMethod.POST)
    public void createDepartment(
            @RequestBody
                    DepartmentForm departmentForm)
    {
        adminFacade.createDepartment(departmentForm);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<EmployeeData> getAllEmployees()
    {
        return adminFacade.getAllEmployees();
    }

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public List<CompanyData> getAllCompanies()
    {
        return adminFacade.getAllCompanies();
    }
}
