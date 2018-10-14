package com.kh.dep.addressBook.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.member.model.vo.Member;

@Repository
public class AddressBookDaoImpl implements AddressBookDao{

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<Member> searchAdd(String name) {
		List<Member> list = sqlSession.selectList("AddressBook.searchAddressBook", name);
		
		return list;
	}

	@Override
	public AddressBook selectAdd(int empNo) {
		return sqlSession.selectOne("AddressBook.selectAdd", empNo);
	}

	@Override
	public int insertAdd(AddressBook ab) {
		return sqlSession.insert("AddressBook.insertAdd", ab);
	}
	
	
	@Override
	public List<AddressBook> selectAddList() {
		return sqlSession.selectList("AddressBook.selectAddList");
	}

	@Override
	public int deleteAdd(AddressBook ab) {
		return sqlSession.delete("AddressBook.deleteAdd", ab);
	}



}
