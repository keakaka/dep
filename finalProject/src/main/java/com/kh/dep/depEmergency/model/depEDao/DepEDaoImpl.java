package com.kh.dep.depEmergency.model.depEDao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.depEmergency.model.exception.DepESelectListException;
import com.kh.dep.facing.model.exception.FacingSelectListException;

@Repository
public class DepEDaoImpl implements DepEDao {

	@Override
	public ArrayList selectDepeList(SqlSessionTemplate sqlSession , String depName) throws DepESelectListException {
		// TODO Auto-generated method stub
		ArrayList DepEList = (ArrayList) sqlSession.selectList("DepE.selectDepeList", depName);
		if(DepEList == null )
		{
			throw new DepESelectListException("리스트 조회 실패");
		}
		
		return DepEList;
	}

}
