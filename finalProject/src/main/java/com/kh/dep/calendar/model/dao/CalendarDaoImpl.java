package com.kh.dep.calendar.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.member.model.vo.Member;

@Repository
public class CalendarDaoImpl implements CalendarDao{
	
	@Inject
	SqlSession sqlSession;

	@Override
	public List<AddressBook> selectAttList() {
		return sqlSession.selectList("Calendar.selectAttList");
	}
	
	@Override
	public List<Member> searchAttName(String attName) {
		List<Member> list = sqlSession.selectList("Calendar.searchAttendance",attName);
		return list;
	}

}
