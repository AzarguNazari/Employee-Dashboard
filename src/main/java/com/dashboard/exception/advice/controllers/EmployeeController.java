package com.dashboard.exception.advice.controllers;

import com.dashboard.service.exceptions.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
		logger.error("Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}
	
//	@ExceptionHandler(EmployeeNotFoundException.class)
//	public @ResponseBody ExceptionJSONInfo handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
//		
//		ExceptionJSONInfo response = new ExceptionJSONInfo();
//		response.setUrl(request.getRequestURL().toString());
//		response.setMessage(ex.getMessage());
//		
//		return response;
//	}
	
}
