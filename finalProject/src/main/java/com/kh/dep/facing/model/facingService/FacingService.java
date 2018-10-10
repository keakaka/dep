package com.kh.dep.facing.model.facingService;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.facing.model.exception.FacingSelectListException;
import com.kh.dep.facing.model.vo.Facing;

public interface FacingService {


	ArrayList<Facing> selectFacingList(int userNo) throws FacingSelectListException;

	List<Facing> selectReciveList(int empNO);

	Facing selectOneFacing(int fNo) throws FacingSelectListException;

	ArrayList<Facing> updateFacing(int fNo, int fus) throws FacingSelectListException; 

/*	Facing selectInsertFaicng(int empNo);
*/	
	
	
	
	
	
}
