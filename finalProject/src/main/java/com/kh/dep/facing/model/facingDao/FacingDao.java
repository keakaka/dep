package com.kh.dep.facing.model.facingDao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.facing.model.vo.Facing;

public interface FacingDao {

	ArrayList<Facing> selectFacingList(SqlSessionTemplate sqlSession ,Facing f);
	
	

}
