package com.qnetemployee.qnetdemo.controller;

import com.qnetemployee.qnetdemo.entity.QnetEmployee;
import com.qnetemployee.qnetdemo.service.QnetEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/system")
public class QnetEmployeeController {

    private QnetEmployeeService qnetEmployeeService;

    @Autowired
    public QnetEmployeeController(QnetEmployeeService qnetEmployeeService) {
        this.qnetEmployeeService = qnetEmployeeService;
    }

    @GetMapping("/list")
    public String employeeList(Model theModel){

        List<QnetEmployee> theEmployee = qnetEmployeeService.findAll();

        theModel.addAttribute("qnetemployee",theEmployee);

        return "/list-employees";
    }

    // Mapping to show Employees List for Employee Role
    @GetMapping("/employeesList")
    public String employeeRole(Model theModel){
        List<QnetEmployee> theEmployee = qnetEmployeeService.findAll();

        theModel.addAttribute("qnetemployee",theEmployee);

        return "employeesdata";
    }

    // Mapping to show Employees List for Manager Role
    @GetMapping("/managersView")
    public String managerRole(Model theModel){
        List<QnetEmployee> theEmployee = qnetEmployeeService.findAll();

        theModel.addAttribute("qnetemployee",theEmployee);

        return "employee-full-data";
    }

    @GetMapping("/formForAdd")
    public String showFormForAdd(Model theModel){

        QnetEmployee theEmployee = new QnetEmployee();

        theModel.addAttribute("qnetemployee",theEmployee);

        return "employee-form";
    }

    //mapping for update
    @GetMapping("/formForUpdate")
    public String showFormForUpdate(@RequestParam("qnetemployeeId") int theId,Model theModel){

        QnetEmployee theEmployee = qnetEmployeeService.findById(theId);

        theModel.addAttribute("qnetemployee",theEmployee);

        return "employee-form";
    }

    //mapping for delete
    @GetMapping("/delete")
    public String delete(@RequestParam("qnetemployeeId") int theId){

        qnetEmployeeService.deleteById(theId);

        return "redirect:/system/list";
    }

    //mapping to save new employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("qnetemployee") QnetEmployee theEmployee){

        qnetEmployeeService.Save(theEmployee);

        return "redirect:/system/list";

    }




}
