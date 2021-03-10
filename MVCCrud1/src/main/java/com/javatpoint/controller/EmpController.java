package com.javatpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatpoint.bean.Emp;
import com.javatpoint.dao.EmpDao;

@Controller

public class EmpController {
	@Autowired
	EmpDao empDao = null;

	@RequestMapping("/addEmployee")
	public String addEmployee(Model model) {
		Emp emp = new Emp();
		model.addAttribute("employee",emp);
	//	model.addAttribute("command", new Emp());
		return "addEmployee";
		
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("employee") Emp emp) {
		empDao.save(emp);
		return "redirect:/viewEmployee";
	}
	
	@RequestMapping(value="/viewEmployee")
	public String viewEmployee(Model model) {
		List<Emp> list = empDao.getEmployees();
		model.addAttribute("list", list);
		return "viewEmployee";
	}
	@RequestMapping(value="/editemp/{id}") 
	public String editEmployee(@PathVariable int id, Model model) {
		Emp emp = empDao.getEmpById(id);
		model.addAttribute("employee", emp);
		return "editForm";
	}
	
	@RequestMapping(value="/editSave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") Emp emp){    
        empDao.update(emp);    
        return "redirect:/viewEmployee";    
    }
	
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        empDao.delete(id);    
        return "redirect:/viewEmployee";    
    }   
	
	
	public void generatePDF() {
		empDao.generatePDF();
	}
}
