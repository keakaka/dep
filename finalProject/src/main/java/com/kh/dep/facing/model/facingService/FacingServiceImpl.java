package com.kh.dep.facing.model.facingService;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.facing.model.exception.FacingSelectListException;
import com.kh.dep.facing.model.facingDao.FacingDao;
import com.kh.dep.facing.model.vo.Alram;
import com.kh.dep.facing.model.vo.Facing;
import com.kh.dep.facing.model.vo.FacingInsert;
import com.kh.dep.facing.model.vo.FacingInsertR;
import com.kh.dep.facing.model.vo.WorkingQr;
import com.kh.dep.facing.model.vo.WorkingRecord;
import com.kh.dep.member.model.vo.Member;
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
		
		ArrayList<Facing> Facinglist = fd.selectFacingList(sqlSession,userNo);
		
		return Facinglist;
		
	}
	@Override
	public ArrayList<Facing> selectReciveList(int empNo) throws FacingSelectListException {
		// TODO Auto-generated method stub
		
		ArrayList<Facing> FacingReciverList = fd.selectReciveList(sqlSession,empNo);
		
		return FacingReciverList;
	}
	@Override
	public Facing selectOneFacing(int facingNo) throws FacingSelectListException {
		// TODO Auto-generated method stub
		Facing f = fd.selectOneFaicng(sqlSession , facingNo);
		
		
		return f;
	}
	@Override
	public int updateFacing(int fNo ) throws FacingSelectListException {
		// TODO Auto-generated method stub
		ArrayList<Facing> list = null;
		int result = fd.updateFacing(sqlSession, fNo);
		
		/*if(result > 0)
		{	
			System.out.println("값 받아옴 리스트 뿌리자~");
			list = fd.selectFacingList(sqlSession, fus);
		}*/
		return result;
	}
	
	@Override
	public int InsertWorking(int empNo) {
		// TODO Auto-generated method stub
		int result = fd.insertWorking(sqlSession,empNo);
		
		return result;
		
	}
	@Override
	public int insertFacing(FacingInsert fi) {
		// TODO Auto-generated method stub
		int result = fd.insertFacing(sqlSession , fi);
		
		return result;
	}
	@Override
	public Facing selectNowFacing(int empNo) {
		// TODO Auto-generated method stub
		
		Facing nowFacing = (Facing) fd.selectNowFaicng(empNo);
		
		return nowFacing;
	}
	@Override
	public int insertReceiver(FacingInsertR fir) {
		// TODO Auto-generated method stub
		int resultR = fd.insertReceiver(fir);
		return resultR;
	}
	@Override
	public int insertAlram(Alram al) {
		// TODO Auto-generated method stub
		int alram = fd.insertAlram(al);
		return alram;
	}
	
	@Override
	public ArrayList<WorkingQr> selectWorking(int empNo) {
		// TODO Auto-generated method stub
		
		ArrayList<WorkingQr> qrList = fd.selectWorking(sqlSession,empNo);
		
		return qrList;
	}
	@Override
	public int updateAlram(int fNo) {
		// TODO Auto-generated method stub
		int result2 = fd.updateAlram(fNo);
		return result2;
	}
	@Override
	   public int selectAlarmCount(int receiverEmpNo) {
	      
	      return fd.selectAlarmCount(sqlSession, receiverEmpNo);
	   }
	@Override
	public int deleteAlarm(int fNo) {
		
		return fd.deleteAlarm(sqlSession, fNo);
	}
	
		
}
