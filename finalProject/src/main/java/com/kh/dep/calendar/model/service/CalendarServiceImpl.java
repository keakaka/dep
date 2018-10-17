package com.kh.dep.calendar.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.calendar.model.dao.CalendarDao;
import com.kh.dep.calendar.model.vo.Calendar;
import com.kh.dep.member.model.vo.Member;

@Service
public class CalendarServiceImpl implements CalendarService{
	
	@Autowired
	private CalendarDao cd;
	
	@Override
	public List<AddressBook> selectAttList() {
		return cd.selectAttList();
	}

	@Override
	public List<Member> searchAttName(String attName) {
		return cd.searchAttName(attName);
	}

	@Override
	public Calendar insertCalendar(Calendar c) {
		System.out.println("CalendarServiceImple c : " + c);
		/*int loginNo = c.getEmpNo();*/
		/*Calendar ci = cd.selectCalendar(loginNo);*/
		/*System.out.println("CalendarServiceImpl c : " + ci);*/
		
		int result = cd.insertCalendar(c);
		
		return c;
	}

	@Override
	public List<Calendar> selectCalendar(int empNo) {
		return cd.selectCalendar(empNo);
	}

	@Override
	public int selectCurval() {
		return cd.selectCurval();
	}


}
