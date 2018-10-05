package com.kh.dep.calendar.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.dep.calendar.model.vo.Calendar;

@Controller
@SessionAttributes("loginUser")
public class CalendarController {
	
	
	@RequestMapping(value="calendar.ca")
	public String showCalendarView(){
		return "calendar/calendar";
	}
	
	
	@RequestMapping(value="searchMemberByName.ca")
	public String searchAttendants(String name, HttpServletRequest request){
		ArrayList<Calendar> list = null;
		
		return "calendar/searchAttendants";
	}
	
	
	
	

}
