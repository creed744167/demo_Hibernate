package com.companyportal.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayRegistrationForm(Model model) {
		Employee employee = new Employee();	
		
		model.addAttribute("employee", employee);
		return "employeeform";
		
		//return new ModelAndView("employeeform", "employee", employee);
		 
	}
	
	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	public String saveEmployeeData(@ModelAttribute Employee employee) {
	if(employee.getEmployeeId() !=null ) {
	employeeService.updateEmployeeData(employee);
	} else {
	employeeService.saveEmployeeData(employee);
	}



	System.out.println("employee id : "+employee.getEmployeeId());
	return "redirect:/employeelist";
	}
	
	@RequestMapping(value = "/employeelist", method = RequestMethod.GET)
	public String getEmployeesData(Model model) {
		List<Employee> employeeList = employeeService.getEmployeesData();
				
		model.addAttribute("employeeList", employeeList);
		return "employeelist";
	}
	
	@RequestMapping(value = "/updateEmployee{employeeId}", method = RequestMethod.GET)
    public ModelAndView updateEmployeeData(@RequestParam Integer employeeId) {
        
        Employee employee = employeeService.getSingleEmployeeData(employeeId);
        return new ModelAndView("employeeform", "employee", employee);
    }
	
	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.GET)
    public String deleteEmployeeData(@PathVariable("employeeId") Integer employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        
        return "redirect:/employeelist";
    }
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public ModelAndView searchData(@RequestParam("string")String string){
		List<Employee> employeesList=employeeService.getSearchData(string);
		return new ModelAndView("employeelist","employeeList",employeesList);
	}
}

