package com.kh.dep.facing.model.facingService;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.facing.model.exception.FacingSelectListException;
import com.kh.dep.facing.model.facingDao.FacingDao;
import com.kh.dep.facing.model.vo.Facing;
import com.kh.dep.member.model.vo.MemberJob;

import oracle.net.aso.f;

@Service
public class FacingServiceImpl implements FacingService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private FacingDao fd;
	@Override
	public ArrayList<Facing> selectFacingList(int userNo) throws FacingSelectListException {
		// TODO Auto-generated method stub
		
		System.out.println("서비스 입장");
		ArrayList<Facing> Facinglist = fd.selectFacingList(sqlSession,userNo);
		
		
		
		System.out.println("돌아온 리스트 값 :" + Facinglist);
		
		
		
		return Facinglist;
		
	}
	@Override
	public List<Facing> selectReciveList(int empNo) {
		// TODO Auto-generated method stub
		
		List<Facing> FacingList = fd.selectReciveList(sqlSession,empNo);
		
		return FacingList;
	}
/*	@Override
	public int insertFaicng(int empNo, Facing f) {
		// TODO Auto-generated method stub
		
		return fd.insertFacing(sqlSession,f,empNo);
		
	}*/
	/*@Override
	public Facing selectInsertFaicng(int empNo) {
		// TODO Auto-generated method stub
		Facing f = fd.selectInsertFacing(sqlSession,empNo);
		int result = fd.insertFacing(sqlSession,f);
		
		return f;
	}
*/
	@Override
	public Facing selectOneFacing(int facingNo) throws FacingSelectListException {
		// TODO Auto-generated method stub
		Facing f = fd.selectOneFaicng(sqlSession , facingNo);
		
		System.out.println("돌아온 쪽지 상세보기 : " + f);
		
		return f;
	}
	@Override
	public ArrayList<Facing> updateFacing(int fNo , int fus) throws FacingSelectListException {
		// TODO Auto-generated method stub
		System.out.println("쪽지 서비스 입장");
		ArrayList<Facing> list = null;
		int result = fd.updateFacing(sqlSession, fNo);
		
		if(result > 0)
		{	
			System.out.println("값 받아옴 리스트 뿌리자~");
			list = fd.selectFacingList(sqlSession, fus);
		}
		return list;
	}



	
		
}
