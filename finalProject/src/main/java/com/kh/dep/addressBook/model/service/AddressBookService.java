package com.kh.dep.addressBook.model.service;

import java.util.List;

import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.member.model.vo.Member;

public interface AddressBookService {

	List<Member> listAll(String name);

	AddressBook selectAdd(int empNo);


}
