package com.kh.dep.facing.model.facingDao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.facing.model.vo.Facing;

@Repository
public class FacingDaoImpl implements FacingDao {

	@Override
	public ArrayList<Facing> selectFacingList(SqlSessionTemplate sqlSession ,Facing f) {
		return null;
		// TODO Auto-generated method stub
		
		
		//return sqlSession.selectList("Facing.selectListFacing",f);
	}

	

}
