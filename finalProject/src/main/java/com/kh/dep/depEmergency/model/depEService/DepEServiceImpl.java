package com.kh.dep.depEmergency.model.depEService;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dep.depEmergency.model.depEDao.DepEDao;
import com.kh.dep.depEmergency.model.vo.DepE;

@Service
public class DepEServiceImpl implements DepEService {

	@Autowired
	private DepEDao dd;
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<DepE> selectDepList() {
		// TODO Auto-generated method stub
		ArrayList  DepEList = dd.selectDepeList();
		
		return  DepEList;
	}
	
}
