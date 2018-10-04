package com.kh.dep.calendar.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loginUser")
public class CalendarController {
	
	
	@RequestMapping(value="calendar.ca")
	public String showCalendarView(){
		return "calendar/calendar";
	}
	
	@RequestMapping(value="searchAtt.ca")
	public String searchAttendantsView(){
		return "calendar/searchAttendants";
	}
	
	@RequestMapping(value="searchMemberByName.ca")
	public String searchAttendants(){
		System.out.println("여기로는 오나염?");
		
		
		return "calendar/searchAttendants";
	}
	
	
	
	

}
