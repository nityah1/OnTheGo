package com.unicorn.mytime.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {


	@RequestMapping(value={"/","/welcome**","/logout**"}, method=RequestMethod.GET)
	public ModelAndView welcomePage(HttpServletRequest request, @RequestParam(value = "error", required = false) String error,
								@RequestParam(value = "logout", required = false) String logout) {
		

		ModelAndView model = new ModelAndView();
		
		if (logout != null){
			clearAuthenticationAttributes(request);
			model.addObject("msg", "Yoy have been logged out successfully.");
			model.setViewName("login");
		} else {
			model.addObject("title", "Welcome to MyTime!!");
			model.setViewName("welcome");
		}
		return model;
			
	}
	

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/admin**", method=RequestMethod.GET)
	public ModelAndView adminPage(HttpServletRequest request, @RequestParam(value = "error", required = false) String error,
								@RequestParam(value = "logout", required = false) String logout) {
		 
		
		UserDetails userDetails =
				 (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		ModelAndView model = new ModelAndView();
		if (logout != null){
			clearAuthenticationAttributes(request);
			model.setViewName("login");
		} else {
			model.addObject("title", "Welcome to MyTime!!");
			model.addObject("message", "This is protected page!");
			model.setViewName("admin");
		}
		return model; 
	}
	
	
	@RequestMapping(value="/login**", method=RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
								@RequestParam(value = "logout", required = false) String logout) {
		 
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
 
		return model; 
	}
		
	
	
}
