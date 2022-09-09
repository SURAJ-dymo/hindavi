package com.prog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Employe;
import com.prog.repository.EmpRepo;
import com.prog.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
@GetMapping("/")
	public String home(Model m) {
		
		List<Employe>emp=service.getAllEmploy();
		m.addAttribute("emp",emp);
		
		return "index";
	}
@GetMapping("/addemp")
public String addEmpForm() {
	
	
	return "add_Emp";
}

@PostMapping("/register")
public String empRegister(@ModelAttribute Employe e,HttpSession session) {
	service.addEmp(e);
	System.out.print(e);
	session.setAttribute("msg","Employe added sucessfully..");
	return "redirect:/";
}
@GetMapping("/edit/{id}")
public String edit(@PathVariable int id,Model m) {
	
	Employe e=service.getEmployById(id);
	m.addAttribute("emp",e);
	
	return "edit";
}
@PostMapping("/update")
public String updateEmp(@ModelAttribute Employe e,HttpSession session ) {
	
	service.addEmp(e);
	session.setAttribute("msg","Employe updated sucessfully..");
	return "redirect:/";
}
@GetMapping("/delete/{id}")
public String deleteEmp(@PathVariable int id,HttpSession session) {
	Employe e=service.getEmployById(id);
	service.deleEmp(e);
	session.setAttribute("msg","Employe delete sucessfully..");
	return "redirect:/";
}

}
