package com.kh.dep.facing.model.facingDao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.facing.model.exception.FacingSelectListException;
import com.kh.dep.facing.model.vo.Alram;
import com.kh.dep.facing.model.vo.Facing;
import com.kh.dep.facing.model.vo.FacingInsert;
import com.kh.dep.facing.model.vo.FacingInsertR;
import com.kh.dep.facing.model.vo.WorkingQr;
import com.kh.dep.facing.model.vo.WorkingRecord;
import com.kh.dep.member.model.vo.Member;

@Repository
public class FacingDaoImpl implements FacingDao {
	@Inject
	SqlSession sqlSession;
	private ArrayList<Object> FaicngList;
	
	@Override
	public ArrayList<Facing> selectFacingList(SqlSessionTemplate sqlSession, int empNo ) throws FacingSelectListException   {
		// TODO Auto-generated method stub
		
		ArrayList FacingList = (ArrayList) sqlSession.selectList("Facing.selectFacing", empNo);
		
		if(FacingList == null)
		{
			throw new FacingSelectListException("리스트 조회 실패");
		}
		
		
		return FacingList;
		
	}

	@Override
	public ArrayList<Facing> selectReciveList(SqlSessionTemplate sqlSession, int receiver) throws FacingSelectListException {
		// TODO Auto-generated method stub
		
		
		ArrayList FacingReciverList = (ArrayList) sqlSession.selectList("Facing.reciveFacing",receiver);
		
		
		if(FacingReciverList == null)
		{
			throw new FacingSelectListException("리스트 조회 실패");
		}
		return FacingReciverList;
		
	}

	@Override
	public Facing selectOneFaicng(SqlSessionTemplate sqlSession, int facingNo) throws FacingSelectListException {
		// TODO Auto-generated method stub
		
		Facing f = (Facing) sqlSession.selectOne("Facing.selectOneFacing" , facingNo);
		if(f == null)
		{
			throw new FacingSelectListException("리스트 조회 실패");
		}

		
		
		return f;
	}

	@Override
	public int updateFacing(SqlSessionTemplate sqlSession, int facingNo) {
		// TODO Auto-generated method stub
		
		int result = sqlSession.update("Facing.updateFacing", facingNo);
		
		return result;
	}

	@Override
	public int insertWorking(SqlSessionTemplate sqlSession, int empNo) {
		// TODO Auto-generated method stub
		
		
		int reuselt = sqlSession.insert("Facing.insertWorking",empNo);  
		
		return reuselt;
		
	}

	@Override
	public int insertFacing(SqlSessionTemplate sqlSession, FacingInsert fi) {
		// TODO Auto-generated method stub
		
		
		int result = sqlSession.insert("Facing.insertFacing",fi);
		return result;
	}

	@Override
	public Facing selectNowFaicng(int empNo) {
		// TODO Auto-generated method stub
		
		Facing nowFacing = (Facing) sqlSession.selectOne("Facing.selectNowFaicng",empNo);
		return nowFacing;
	}

	@Override
	public int insertReceiver(FacingInsertR fir) {
		// TODO Auto-generated method stub
		int resultR = sqlSession.insert("Facing.insertFaicngR",fir);
		return resultR;
	}

	@Override
	public int insertAlram(Alram al) {
		// TODO Auto-generated method stub
		int alram = sqlSession.insert("Facing.insertAlram",al);
		return alram;
	}

	@Override
	public ArrayList<WorkingQr> selectWorking(SqlSessionTemplate sqlSession,int empNo) {
		// TODO Auto-generated method stub
		
		ArrayList qrList = (ArrayList) sqlSession.selectList("Facing.selectQrList" , empNo);
	
		
		return qrList;
	}

	@Override
	public int updateAlram(int fNo) {
		int result2 = sqlSession.delete("Facing.updateAlram",fNo);
		return result2;
	}

	@Override
	   public int selectAlarmCount(SqlSessionTemplate sqlSession, int receiverEmpNo) {
	      int alarmCount = sqlSession.selectOne("Facing.selectAlarmCount", receiverEmpNo);
	      return alarmCount;
	   }

	@Override
	public int deleteAlarm(SqlSessionTemplate sqlSession, int fNo) {
		int result  = sqlSession.delete("Facing.deleteAlarm", fNo);
	      
	    return result;
	}



	

}
