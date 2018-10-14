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
	public List<Calendar> insertCalendar(Calendar ca) {
		List<Calendar> insertC = cd.selectCalendar(ca);
		int result = cd.insertCalendar(insertC);
		
		return insertC;
	}


}
