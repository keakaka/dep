package com.kh.dep.calendar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/*@SessionAttributes("loginUser")*/
public class CalendarController {
	
	@RequestMapping(value="calendar.ca")
	public String showCalendarView(){
		return "calendar/calendar";
	}

}
