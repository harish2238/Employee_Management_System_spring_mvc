package mvc_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import mvc_spring.dao.EmployeeDAO;
import mvc_spring.dto.Employee;

@Controller
public class Employeecontroller {
	
	@Autowired
	Employee employee;
	@Autowired
	EmployeeDAO dao;
	
	@RequestMapping("/saveEmployee")
	public ModelAndView saveEmployee() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("employee",new Employee());
		mav.setViewName("saveEmployee.jsp");
		return mav;
	}
	
	@RequestMapping("/addEmployee")
	public ModelAndView addEmployee(@ModelAttribute Employee employee) {
		dao.saveEmployee(employee);
		ModelAndView mav=new ModelAndView("index.jsp");
		return mav;
	}
	
	@RequestMapping("/viewEmployee")
	public ModelAndView viewEmployee() {
		List<Employee> employee=dao.getAllEmployee();
		ModelAndView mav=new ModelAndView("viewEmployee.jsp");
		mav.addObject("employees", employee);
		return mav;
	}
	
	@RequestMapping("/updateEmployee")
	public ModelAndView updateEmployee(@RequestParam int id) {
		ModelAndView mav=new ModelAndView("updateEmployee.jsp");
		Employee employee=dao.getEmployee(id);
		mav.addObject(employee);
		return mav;
	}
	
	@RequestMapping("/saveupdateEmployee")
	public ModelAndView saveupdateEmployee(@ModelAttribute Employee employee) {
		ModelAndView mav=new ModelAndView("viewEmployee.jsp");
		dao.updateEmployee(employee);
		mav.addObject("employees",dao.getAllEmployee());
		return mav;
	}

	@RequestMapping("/deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam int id) {
		ModelAndView mav=new ModelAndView("viewEmployee.jsp");
		Employee employee=dao.getEmployee(id);
		dao.deleteEmployee(employee);
		mav.addObject("employees", dao.getAllEmployee());
		return mav;
	}
}
