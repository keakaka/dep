package com.kh.dep.sign.model.service;

import java.util.ArrayList;

import com.kh.dep.sign.model.exception.InsertSignException;
import com.kh.dep.sign.model.exception.SelectDocException;
import com.kh.dep.sign.model.vo.Document;
import com.kh.dep.sign.model.vo.InsertSign;
import com.kh.dep.sign.model.vo.MemberDep;

public interface SignService {

	ArrayList<MemberDep> selectMemberDep(String depName);

	int insertSign(InsertSign is) throws InsertSignException;

	ArrayList<Document> selectImWriter(Document doc) throws SelectDocException;

	ArrayList<Document> selectApprovalList(int empNo) throws SelectDocException;
	
}
