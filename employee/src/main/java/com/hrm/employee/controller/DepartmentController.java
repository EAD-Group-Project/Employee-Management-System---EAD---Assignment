package com.hrm.employee.controller;

import com.hrm.employee.model.Department;
import com.hrm.employee.model.Employee;
import com.hrm.employee.model.Manager;
import com.hrm.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/showAllDepartments")
    public String showAllDepartments(Model model, @Param("keyword") String keyword) {
        List<Department> department = departmentService.getAllDepartments(keyword);
        model.addAttribute("department", department);
        model.addAttribute("keyword", keyword);
        return "departments";
    }

    @GetMapping("/showNewDepartmentForm")
    public String showNewDepartmentForm(Model model) {
        // create model attribute to bind form data
        Department department = new Department();
        model.addAttribute("department", department);
        return "new_department";
    }

    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        // save employee to database
        departmentService.saveDepartment(department);
        return "redirect:/showAllDepartments";
    }


    @GetMapping("/showFormForUpdateD/{id}")
    public String showFormForUpdateD(@PathVariable( value = "id") long id, Model model) {

        // get employee from the service
        Department department = departmentService.getDepartmentById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("department", department);
        return "update_department";
    }

    @GetMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable (value = "id") long id) {

        // call delete employee method
        this.departmentService.deleteDepartmentById(id);
        return "redirect:/showAllDepartments";
    }

}
