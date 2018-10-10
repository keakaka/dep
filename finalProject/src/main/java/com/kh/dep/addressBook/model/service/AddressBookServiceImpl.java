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

	//주소록 회원 검색
	@Override
	public List<Member> searchAdd(String name) {
		System.out.println(name + "주소록 서비스impl");
		return abd.searchAdd(name);
	}

	@Override
	public AddressBook insertAdd(int empNo, int loginNo) {
		AddressBook ab = abd.selectAdd(empNo);
		ab.setLoginNo(loginNo);
		int result = abd.insertAdd(ab);
		
		return ab;
	}

	@Override
	public List<AddressBook> selectAddList() {
		return abd.selectAddList();
	}

	@Override
	public AddressBook deleteAddressBook(int empNo) {
		AddressBook ab = abd.selectAdd(empNo);
		int result = abd.deleteAdd(ab);
		
		return ab;
	}

	


}
