package com.kh.dep.facing.model.facingDao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.facing.model.exception.FacingSelectListException;
import com.kh.dep.facing.model.vo.Facing;

@Repository
public class FacingDaoImpl implements FacingDao {
	@Inject
	SqlSession sqlSession;
	private ArrayList<Object> FaicngList;
	
	@Override
	public ArrayList<Facing> selectFacingList(SqlSessionTemplate sqlSession, int empNo ) throws FacingSelectListException   {
		// TODO Auto-generated method stub
		
		System.out.println("다오 입장");
		ArrayList FacingList = (ArrayList) sqlSession.selectList("Facing.selectFacing", empNo);
		
		System.out.println("FacingList : " + FacingList );
		if(FacingList == null)
		{
			throw new FacingSelectListException("리스트 조회 실패");
		}
		System.out.println("FacingList : " + FacingList );
		
		
		return FacingList;
		
	}

	@Override
	public List<Facing> selectReciveList(SqlSessionTemplate sqlSession, int empNo) {
		// TODO Auto-generated method stub
		
		System.out.println("다오입장");
		
		List FacingList = (List) sqlSession.selectList("Facing.reciveFacing",empNo);
		
		System.out.println("돌아온 리스트 값" + FacingList);
		
		return FacingList;
		
	}

	@Override
	public Facing selectOneFaicng(SqlSessionTemplate sqlSession, int facingNo) throws FacingSelectListException {
		// TODO Auto-generated method stub
		System.out.println("상세보기 다오입장!");
		
		Facing f = (Facing) sqlSession.selectOne("Facing.selectOneFacing" , facingNo);
		
		if(f == null)
		{
			throw new FacingSelectListException("리스트 조회 실패");
		}

		System.out.println("돌아온 상세보기 :" + f);
		
		
		return f;
	}

	@Override
	public int updateFacing(SqlSessionTemplate sqlSession, int facingNo) {
		// TODO Auto-generated method stub
		
		int result = sqlSession.update("Facing.updateFacing", facingNo);
		
		System.out.println("돌아온 업데이트 리절트 값" + result);
		return result;
	}

/*	@Override
	public int insertFacing(SqlSessionTemplate sqlSession, Facing f) {
		// TODO Auto-generated method stub
		
		System.out.println("인설트 다오 도착 ");
		
		return sqlSession.insert("Facing.insertFacing" , f);
	}

	@Override
	public Facing selectInsertFacing(SqlSessionTemplate sqlSession, int empNo) {
		// TODO Auto-generated method stub
		return null;
	}*/

	

}
