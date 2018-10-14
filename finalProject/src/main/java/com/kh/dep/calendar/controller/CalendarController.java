package com.kh.dep.calendar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.calendar.model.service.CalendarService;
import com.kh.dep.calendar.model.vo.Calendar;
import com.kh.dep.member.model.vo.Member;
import com.kh.dep.member.model.vo.MemberSelect;

@Controller
@SessionAttributes("loginUser")
public class CalendarController {
	
	@Autowired
	private CalendarService cs;
	
	
	@RequestMapping(value="calendar.ca")
	public String showCalendarView(HttpServletRequest request, Model model){
		MemberSelect ms = (MemberSelect)request.getSession().getAttribute("loginUser");
		int empNo = ms.getEmpNo();
		
		List<Calendar> list = cs.selectCalendar(empNo);
		System.out.println("CalendarController list : " + list);
		
		model.addAttribute("list", list);
		
		return "calendar/calendar";
	}
	
	@RequestMapping("insertAttendance.ca")
	public String insertAttenance() {
		return "calendar/insertAttendance";
	}
	
	
	@RequestMapping(value = "searchAttName.ca", produces = "application/text; charset=utf-8")
	public void searchAttName(@RequestParam String attName, HttpServletResponse response) {
		System.out.println("searchAttName name : " + attName);
		
		List<AddressBook> list = cs.selectAttList();
		System.out.println("calendar controller list : " + list);
		
		List<Member> list2 = cs.searchAttName(attName);
		System.out.println("searchAttName list : " + list2);
		
		try {
			response.getWriter().print(list2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*try {
			PrintWriter out = response.getWriter();
			
	        JSONObject json = new JSONObject();
	        json.put("data", list2);
	        
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	@RequestMapping("insertCalendar.ca")
	public void insertCalendar(String title, String content, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("insertCalendar title : " + title);
		System.out.println("insertCalendar content : " + content);
		
		MemberSelect ms = (MemberSelect)request.getSession().getAttribute("loginUser");
		int loginNo = ms.getEmpNo();
		System.out.println("Calendar loginNo : " + loginNo);
		Calendar c = new Calendar();
		c.setEmpNo(loginNo);
		c.setScheduleTitle(title);
		c.setScheduleContent(content);
		
		System.out.println("CalendarController c : " + c);
		
		
		Calendar ca2 = cs.insertCalendar(c);
		System.out.println("insert ca2 : " + ca2);
	
	}
}
