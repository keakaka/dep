package com.kh.dep.calendar.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.calendar.model.service.CalendarService;
import com.kh.dep.member.model.vo.Member;

@Controller
@SessionAttributes("loginUser")
public class CalendarController {
	
	@Autowired
	private CalendarService cs;
	
	
	@RequestMapping(value="calendar.ca")
	public String showCalendarView(){
		return "calendar/calendar";
	}
	
	@RequestMapping("insertAttenance.ca")
	public String insertCalendar() {
		return "calendar/insertAttendance";
	}
	
	
	@RequestMapping("searchAttName.ca")
	public void searchAttName(String attName, HttpServletResponse response) {
		System.out.println("searchAttName name : " + attName);
		
		List<AddressBook> list = cs.selectAttList();
		System.out.println("calendar controller list : " + list);
		
		List<Member> list2 = cs.searchAttName(attName);
		System.out.println("searchAttName list : " + list2);
		
	}
	
	

}
