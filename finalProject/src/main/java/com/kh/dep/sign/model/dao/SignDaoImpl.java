package com.kh.dep.sign.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.sign.model.vo.Document;
import com.kh.dep.sign.model.vo.InsertSign;
import com.kh.dep.sign.model.vo.MemberDep;

@Repository
public class SignDaoImpl implements SignDao{


	@Override
	public ArrayList<MemberDep> selectMemberDep(SqlSessionTemplate sqlSession, String depName) {
		
		return (ArrayList)sqlSession.selectList("sign.selectMemberDep", depName);
	}

	@Override
	public int insertDocApproval(SqlSessionTemplate sqlSession, InsertSign is) {
		return sqlSession.insert("sign.insertDocApproval", is);
	}

	@Override
	public int selectGetDocNoSeq(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("sign.selectGetDocNoSeq");
	}
	
	@Override
	public int insertApproval_record(SqlSessionTemplate sqlSession, InsertSign is) {
		return sqlSession.insert("sign.insertApprovalRecord", is);
	}

	@Override
	public int insertReceiving_Check(SqlSessionTemplate sqlSession, InsertSign is) {
		return sqlSession.insert("sign.insertReceivingCheck", is);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate sqlSession, InsertSign is) {
		return sqlSession.insert("sign.insertAttachment", is);
	}

	@Override
	public ArrayList<Document> selectImWriter(SqlSessionTemplate sqlSession, Document doc) {
		return (ArrayList)sqlSession.selectList("sign.selectImWriter", doc);
	}

	@Override
	public ArrayList selectGetDocNo(SqlSessionTemplate sqlSession, int empNo) {
		
		return (ArrayList)sqlSession.selectList("sign.selectGetDocNo", empNo);
	}

	@Override
	public Document selectApprovalList(SqlSessionTemplate sqlSession, Object object) {
		
		int docNo = (Integer)object;
		
		return sqlSession.selectOne("sign.selectApprovalList", docNo);
	}

	

	
	
}
