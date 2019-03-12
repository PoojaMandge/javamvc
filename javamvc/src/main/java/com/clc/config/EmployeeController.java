package com.clc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
	
	@Autowired
	EmpService service;
	
	@RequestMapping(value ="/emps/", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("empob", new EmpBean());
		model.addAttribute("listemps", this.service.getAllEmps());
		return "empinfo";
	}

	

	@RequestMapping(value= "/addemp/", method = RequestMethod.POST)
	public String saveEmpInfo(@ModelAttribute("empob") EmpBean p){
		System.out.println("inside controller...." +p);
		if(p.getEmpId() == 0){
			//new person, add it
			this.service.addEmp(p);
		}else{
			//existing person, call update
			this.service.updateEmp(p);
		}
		
		return "redirect:/emps/";
		
	}
	
	
	@RequestMapping("/remove/{id}")
    public String removeEmp(@PathVariable("id") int id){
        this.service.deleteEmp(id);
        return "redirect:/emps/";
    }
 
    @RequestMapping("/edit/{id}")
    public String editEmp(@PathVariable("id") int id, Model model){
        model.addAttribute("empob", this.service.getEmp(id));
        model.addAttribute("listemps", this.service.getAllEmps());
        return "empinfo";
    }
	
}
