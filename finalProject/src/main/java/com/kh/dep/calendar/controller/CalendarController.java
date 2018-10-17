package com.kh.dep.calendar.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.calendar.model.service.CalendarService;
import com.kh.dep.calendar.model.vo.Calendar;
import com.kh.dep.calendar.model.vo.DayWeek;
import com.kh.dep.member.model.vo.Member;
import com.kh.dep.member.model.vo.MemberSelect;

@Controller
@SessionAttributes("loginUser")
public class CalendarController {
	
	@Autowired
	private CalendarService cs;
	
	
	@RequestMapping(value="calendar.ca")
	public String showCalendarView(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		/*MemberSelect ms = (MemberSelect)request.getSession().getAttribute("loginUser");
		int empNo = ms.getEmpNo();
		
		List<Calendar> list = cs.selectCalendar(empNo);
		System.out.println("CalendarController list : " + list);
		
		model.addAttribute("list", list);
		
		*/
		return "calendar/calendar";
	}
	
	@RequestMapping(value = "calendarList.ca", method=RequestMethod.POST)
	 @ResponseBody 
	public Object calendarList(@RequestParam String title, Map<String, Object> map,
								HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CalendarController calendarList에 왔음");
		
		MemberSelect ms = (MemberSelect)request.getSession().getAttribute("loginUser");
		int empNo = ms.getEmpNo();
		
		List<Calendar> list = cs.selectCalendar(empNo);
		System.out.println("CalendarController list : " + list);
		
	      
	      for(int i=0; i<list.size(); i++){
	         String str = ((Calendar) list.get(i)).getScheStartDate();
	         /*System.out.println(str.substring(8, 10));*/
	         ((Calendar) list.get(i)).setDayNum(str.substring(5, 10));
	         
	         String day;
			
	         
			 day = DayWeek.getDateDay(((Calendar) list.get(i)).getScheStartDate().substring(0, 11), "yyyy-MM-dd");
				((Calendar) list.get(i)).setDayWeek(day);
			
			
	         
	    }
		
	     for(int i=0; i<list.size(); i++) {
	    	 System.out.println(i + " : " + list.get(i).toString());
	     }
	      
		Map<String, Object> ret = new HashMap<String, Object>();
	    
	    ret.put("cList", list);
	    
	    return ret;
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
	public void insertCalendar(String title, String content, String sDate, String eDate, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("insertCalendar title : " + title);
		System.out.println("insertCalendar content : " + content);
		
		MemberSelect ms = (MemberSelect)request.getSession().getAttribute("loginUser");
		int loginNo = ms.getEmpNo();
		System.out.println("Calendar loginNo : " + loginNo);
		Calendar c = new Calendar();
		c.setEmpNo(loginNo);
		c.setScheduleTitle(title);
		c.setScheduleContent(content);
		c.setScheStartDate(sDate);
		c.setScheEndDate(eDate);
		
		System.out.println("CalendarController Insert c : " + c);
		
		
		Calendar ca2 = cs.insertCalendar(c);
		System.out.println("insert ca2 : " + ca2);
		
		int next = cs.selectCurval();
		System.out.println("CalendarController insert next : " + next);
		
		MemberSelect ms2 = (MemberSelect)request.getSession().getAttribute("loginUser");
		int empNo = ms2.getEmpNo();
		List<Calendar> list = cs.selectCalendar(empNo);
		
		model.addAttribute("list2", list);
	
	}
	
	/*@RequestMapping(value="deleteCalendar.ca")
	public String deleteCalendar() {
		
		
	}*/
}
