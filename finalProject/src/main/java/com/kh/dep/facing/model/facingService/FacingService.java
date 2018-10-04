package com.kh.dep.facing.model.facingService;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.facing.model.vo.Facing;

public interface FacingService {

	

	ArrayList<Facing> selectFacingList(SqlSessionTemplate sqlSession ,Facing f); 
	
	
}
