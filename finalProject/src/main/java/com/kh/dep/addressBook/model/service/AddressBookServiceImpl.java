package com.kh.dep.addressBook.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dep.addressBook.model.dao.AddressBookDao;
import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.member.model.vo.Member;

@Service
public class AddressBookServiceImpl implements AddressBookService{
	
	@Autowired
	private AddressBookDao abd;

	@Override
	public List<Member> listAll(String name) {
		System.out.println(name + "주소록 서비스impl");
		return abd.listAll(name);
	}

	@Override
	public AddressBook selectAdd(int empNo) {
		AddressBook ab = abd.selectAdd(empNo);
		int result = abd.insertAdd(ab);
		
		return ab;
	}
	


}
