package com.kh.dep.calendar.model.dao;

import java.util.List;

import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.member.model.vo.Member;

public interface CalendarDao {
	
	List<AddressBook> selectAttList();

	List<Member> searchAttName(String attName);


}
