package com.kh.dep.member.model.service;

import com.kh.dep.member.exception.LoginException;
import com.kh.dep.member.model.vo.Member;
import com.kh.dep.member.model.vo.MemberSelect;

public interface MemberService {

	MemberSelect selectLoginMember(MemberSelect m) throws LoginException;

}
