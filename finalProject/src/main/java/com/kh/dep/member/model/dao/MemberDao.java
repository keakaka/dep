package com.kh.dep.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.member.model.vo.Department;
import com.kh.dep.member.model.vo.Job;
import com.kh.dep.member.model.vo.Member;
import com.kh.dep.member.model.vo.MemberDepartment;
import com.kh.dep.member.model.vo.MemberJob;
import com.kh.dep.member.model.vo.MemberSelect;
import com.kh.dep.member.model.vo.Position;

public interface MemberDao {

	MemberSelect selectLoginMember(SqlSessionTemplate sqlSession, MemberSelect m);

	String selectEncpassword(SqlSessionTemplate sqlSession, MemberSelect m);


	int updateMyInfo(SqlSessionTemplate sqlSession, MemberSelect m) throws Exception;

	ArrayList<MemberDepartment> selectdepList(SqlSessionTemplate sqlSession);

	ArrayList<MemberJob> selectJobList(SqlSessionTemplate sqlSession);

	int insertMember(SqlSessionTemplate sqlSession, MemberSelect m);


	List<Department> selectMyDepRecordInfo(SqlSessionTemplate sqlSession, String empId) throws Exception;

	List<Job> selectMyJobRecord(SqlSessionTemplate sqlSession, int empNo) throws Exception;

	List<Position> selectMyJobPositionRecord(SqlSessionTemplate sqlSession, int empNo) throws Exception;

	int selectempNumber(SqlSessionTemplate sqlSession);

	ArrayList<Position> selectposiList(SqlSessionTemplate sqlSession);


}
