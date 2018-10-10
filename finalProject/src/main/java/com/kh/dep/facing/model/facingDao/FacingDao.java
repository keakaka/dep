package com.kh.dep.facing.model.facingDao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.facing.model.exception.FacingSelectListException;
import com.kh.dep.facing.model.vo.Facing;
import com.kh.dep.member.model.vo.MemberJob;

public interface FacingDao {

/*	ArrayList<Facing> selectFacingList(SqlSessionTemplate sqlSession ,int userNo);
*/
	
	ArrayList<Facing> selectFacingList(SqlSessionTemplate sqlSession, int userNo) throws FacingSelectListException;

	List<Facing> selectReciveList(SqlSessionTemplate sqlSession, int userNo);

	Facing selectOneFaicng(SqlSessionTemplate sqlSession, int fNo) throws FacingSelectListException;

	int updateFacing(SqlSessionTemplate sqlSession, int fNo);

/*	int insertFacing(SqlSessionTemplate sqlSession, Facing f);

	Facing selectInsertFacing(SqlSessionTemplate sqlSession, int empNo);
*/



}
