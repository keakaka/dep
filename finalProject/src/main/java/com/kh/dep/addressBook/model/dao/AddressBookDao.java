package com.kh.dep.addressBook.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.member.model.vo.Member;

public interface AddressBookDao {

	List<Member> searchAdd(String name);

	AddressBook selectAdd(int empNo);

	int insertAdd(AddressBook ab);

	List<AddressBook> selectAddList();

	int deleteAdd(AddressBook ab);


}
