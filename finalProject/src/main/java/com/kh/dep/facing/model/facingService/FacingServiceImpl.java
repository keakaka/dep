package com.kh.dep.facing.model.facingService;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.dep.facing.model.facingDao.FacingDao;
import com.kh.dep.facing.model.vo.Facing;

import oracle.net.aso.f;

public class FacingServiceImpl implements FacingService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private FacingDao fd;
	
	
	
	@Override
	public ArrayList<Facing> selectFacingList(SqlSessionTemplate sqlSession ,Facing f)
	{
		
		/*ArrayList<Facing> list = new FacingDao.selectFacingList(sqlSession , f);
		
	*/
		
		return null;
	}
	
	
		
}
