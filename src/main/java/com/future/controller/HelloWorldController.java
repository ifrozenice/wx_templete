package com.future.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hello")
public class HelloWorldController{

	@RequestMapping(value = "/{userName}")
	public ModelAndView index(
			@PathVariable("userName") String userName, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();
		mav.addObject("userName", userName);
		mav.setViewName("/index");
		return mav;
	}

}
