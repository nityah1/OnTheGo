package com.unicorn.mytime.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unicorn.mytime.model.Employee;
import com.unicorn.mytime.service.EmployeeService;

@Controller
public class EmployeeAdminController {

	@Autowired
    private EmployeeService employeeManager;
	
    @RequestMapping(value = "/emplAdmin/all", method = RequestMethod.GET)
    public String listEmployees(ModelMap map)
    {
        map.addAttribute("employeeList", employeeManager.getAllEmployees());
        return "employeeList";
    }
    
    // ADD EMPLOYEE
    @RequestMapping(value = "/emplAdmin/addNew", method = RequestMethod.GET)
    public ModelAndView addNewEmployee() {  
        return new ModelAndView("employeeNew", "employee", new Employee());  
    }  
    
    @RequestMapping(value = "/emplAdmin/add", method = RequestMethod.POST)
    public String addEmployee(@RequestParam(required=false , value = "Submit") String saveFlag, @ModelAttribute(value="employee") Employee employee, BindingResult result)
    {
    	if (!result.hasErrors() && saveFlag != null)	
    		employeeManager.addEmployee(employee);
    	
        return "redirect:/emplAdmin/all";
    }
    
    // EDIT EMPLOYEE
    @RequestMapping(value="/emplAdmin/edit/{employeeId}", method=RequestMethod.GET)
    public ModelAndView editEmployee(@PathVariable("employeeId") String employeeId)
    {
        Employee employee = employeeManager.getEmployee(employeeId);
        return new ModelAndView("employeeEdit", "employee", employee);  
    }  
    
    @RequestMapping(value = "/emplAdmin/update", method = RequestMethod.POST)
    public String updatemployee(@RequestParam(required=false , value = "Submit") String saveFlag , @RequestParam(required=false , value = "Cancel") String cancelFlag, @ModelAttribute(value="employee") Employee employee, BindingResult result)
    {
    	if (saveFlag != null){
	    	if (!result.hasErrors())
	    		employeeManager.updateEmployee(employee);
    	}
    	return "redirect:/emplAdmin/all";
    }
    
    
    // DELETE EMPLOYEE
    @RequestMapping("emplAdmin/delete/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") String employeeId)
    {
        employeeManager.deleteEmployee(employeeId);
    	return "redirect:/emplAdmin/all";
    }
    
    public void setEmployeeManager(EmployeeService employeeManager) {
        this.employeeManager = employeeManager;
    }
}
