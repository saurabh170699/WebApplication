package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class WelcomeController {
	public ModelAndView getWelcomeMsg()
	{
		ModelAndView mav= new ModelAndView();
		mav.addObject("msg", "Order Book Sucessfully");
		
		return mav;
	}

}
