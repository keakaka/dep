package com.kh.dep.facing.model.facingService;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.facing.model.exception.FacingSelectListException;
import com.kh.dep.facing.model.vo.Facing;
import com.kh.dep.facing.model.vo.WorkingRecord;

public interface FacingService {


	ArrayList<Facing> selectFacingList(int userNo) throws FacingSelectListException;

	ArrayList<Facing> selectReciveList(int empNO) throws FacingSelectListException;

	Facing selectOneFacing(int fNo) throws FacingSelectListException;

	ArrayList<Facing> updateFacing(int fNo, int fus) throws FacingSelectListException;

	int InsertWorking(int empNo); 

/*	Facing selectInsertFaicng(int empNo);
*/	
	
	
	
	
	
}
