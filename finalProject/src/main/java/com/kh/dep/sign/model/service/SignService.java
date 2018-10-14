package com.kh.dep.sign.model.service;

import java.util.ArrayList;

import com.kh.dep.sign.model.vo.MemberDep;

public interface SignService {

	ArrayList<MemberDep> selectMemberDep(String depName);
	
}
