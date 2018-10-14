package com.kh.dep.calendar.model.service;

import java.util.List;

import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.calendar.model.vo.Calendar;
import com.kh.dep.member.model.vo.Member;

public interface CalendarService {
	
	List<AddressBook> selectAttList();

	List<Member> searchAttName(String attName);

	Calendar insertCalendar(Calendar c);

	List<Calendar> selectCalendar(int empNo);


}
