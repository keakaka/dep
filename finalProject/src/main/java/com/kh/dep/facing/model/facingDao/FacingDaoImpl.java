package com.kh.dep.facing.model.facingDao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.facing.model.exception.FacingSelectListException;
import com.kh.dep.facing.model.vo.Facing;

@Repository
public class FacingDaoImpl implements FacingDao {

	@Override
	public ArrayList<Facing> selectFacingList(SqlSessionTemplate sqlSession , int empNo )  {
		// TODO Auto-generated method stub
		
		System.out.println("다오 입장");
		return (ArrayList)sqlSession.selectList("Facing.selectFacing", empNo) ;
		
	}


}
