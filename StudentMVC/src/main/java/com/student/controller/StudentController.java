package com.student.controller;   
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.beans.Student;
import com.student.dao.StudentDao;  


@Controller  
public class StudentController {  
	
    @Autowired  
    StudentDao dao;//will inject dao from xml file  
      
    
	 
    @RequestMapping("/studform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Student());
    	return "studform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("stud") Student student){  
        dao.save(student);
        System.out.println("-------------->"+student.getDob());
        return "redirect:/viewstud";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewstud")  
    public String viewemp(Model m){  
        List<Student> list=dao.getStudents();  
        m.addAttribute("list",list);
        return "viewstud";  
    }  
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editstud/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Student student=dao.getStudentById(id);
        m.addAttribute("command",student);
        return "studeditform";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("stud") Student student){  
        dao.update(student);  
        return "redirect:/viewstud";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deletestud/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.deleteStudentById(id); 
        return "redirect:/viewstud";  
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
	/*
	 * public String myDate(Student s) { SimpleDateFormat formatter = new
	 * SimpleDateFormat("dd/MM/yyyy"); String strDate= formatter.format(s.getDob());
	 * System.out.println(strDate); return strDate;
	 * 
	 * }
	 */
}  