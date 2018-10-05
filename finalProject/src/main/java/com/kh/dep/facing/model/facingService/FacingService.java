package com.kh.dep.facing.model.facingService;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.facing.model.exception.FacingSelectListException;
import com.kh.dep.facing.model.vo.Facing;

public interface FacingService {

	ArrayList<Facing> selectFacingList(int userNo) throws FacingSelectListException;

	

/*	ArrayList<Facing> selectFacingList(int userNo);
*/

	
}
