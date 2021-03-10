package com.hr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hr.bean.Student;
import com.hr.exception.StudentException;
import com.hr.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = { "/stud_form" })
	public String studentRegister(Model m) {
		System.out.println("stud_form");
		Student student = new Student();
		m.addAttribute("command", student);
		List<String> list = getList();

        //return back to index.jsp
         m.addAttribute("countryLists", list);
		return "student_form";
	}

	@RequestMapping(value = "/edit_student")
	public String prepareEditForm(Model m, HttpSession session, @RequestParam("cid") Integer id) {
		System.out.println("/edit_student");
		session.setAttribute("sid", id);
		Student s = studentService.findById(id);
		System.out.println(s);
		m.addAttribute("command", s);
		return "student_form";// JSP form view
	}

	@RequestMapping(value = "/stud/save_student", method = RequestMethod.POST)
	public String studentSave(@ModelAttribute("command") Student student, HttpSession session) {
			System.out.println("/stud/save_student");
			Integer id = (Integer) session.getAttribute("sid");
		if (id == null) {
			try {
				System.out.println("save");
				// session.removeAttribute("sid");
				studentService.save(student);
				return "redirect:stud_list?act=reg";
				// redirect:clist?act=ed
			} catch (Exception e) {
				// m.addAttribute("err", "student data not saved");
				e.printStackTrace();
				return "student_form";
			}
		} else {
			try {

				System.out.println("update");
				student.setId(id);
				//student.setDob(new Date());
				studentService.update(student);
				session.removeAttribute("sid");
				return "redirect:stud_list?act=upd";
			} catch (Exception e) {
				// m.addAttribute("err", "student data cant be updated");
				e.printStackTrace();
				return "student_form";
			}
		}

	}

	@RequestMapping(value = {"/", "/stud/stud_list" })
	public String studentList(Model m) {
		System.out.println("stud_list");
		List<Student> studentList = studentService.findAllStudent();
		m.addAttribute("command", studentList);

		return "showAllStudent";
	}

	@RequestMapping(value = { "/stud/del_student" })
	public String deleteStudent(Model m, @RequestParam("cid") Integer id) {
		System.out.println("del_student");
		studentService.delete(id);

		return "redirect:stud_list";
	}
	
	@RequestMapping(value = "/stud/bulk_cdelete")
    public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds) {
		studentService.delete(contactIds);
        return "redirect:stud_list?act=del";
    }

	@RequestMapping(value = "/stud_search")
    public String studentSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText) throws StudentException {
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("command", studentService.findStudent(freeText));
        return "showAllStudent"; //JSP
    }
	
	    

    
	
	private List<String> getList() {

        List<String> list = new ArrayList<String>();
        list.add("India");
        list.add("USA");
        list.add("UK");
        list.add("UAE");
        
        return list;
	}
}
