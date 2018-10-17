package com.kh.dep.sign.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.kh.dep.sign.model.dao.SignDao;
import com.kh.dep.sign.model.exception.InsertSignException;
import com.kh.dep.sign.model.exception.SelectDocException;
import com.kh.dep.sign.model.vo.Document;
import com.kh.dep.sign.model.vo.InsertSign;
import com.kh.dep.sign.model.vo.MemberDep;

@Service
public class SignServiceImpl implements SignService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private SignDao sd;
	
	@Override
	public ArrayList<MemberDep> selectMemberDep(String depName) {
		
		return sd.selectMemberDep(sqlSession, depName);
	}

	@Override
	public int insertSign(InsertSign is) throws InsertSignException{
		int result = 0;
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;
		int result1 = sd.insertDocApproval(sqlSession, is);
		
		int getDocNo = sd.selectGetDocNoSeq(sqlSession);
		is.setDocNo(getDocNo);
		
		for(int i = 0; i < is.getAppList().length; i++){
			is.setEmpNo(is.getAppList()[i]);
			result2 = sd.insertApproval_record(sqlSession, is);
			
		}
		
		for(int i = 0; i < is.getRecList().length; i++){
			is.setEmpNo(is.getRecList()[i]);
			result3 = sd.insertReceiving_Check(sqlSession, is);
		}
		
		if(is.getOriginFileName() != null){
			result4 = sd.insertAttachment(sqlSession, is);
		}
		
		if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0){
			result = 1;
			return result;
		}else{
			throw new InsertSignException("전자문서 기안 실패");
		}
		
	}

	@Override
	public ArrayList<Document> selectImWriter(Document doc) throws SelectDocException {
		ArrayList<Document> list = sd.selectImWriter(sqlSession, doc);
		
		if(list != null){
			return list;
		}else{
			throw new SelectDocException("기안한 문서 조회 실패");
		}
		
	}

	@Override
	public ArrayList<Document> selectApprovalList(int empNo) throws SelectDocException{
		ArrayList docList = sd.selectGetDocNo(sqlSession, empNo);
		
		ArrayList<Document> list = null;
		
		if(docList != null){
			list = new ArrayList();
			for(int i = 0; i < docList.size(); i++){
				Document d = sd.selectApprovalList(sqlSession, docList.get(i));
				
				list.add(d);
			}
		}
		
		return list;
	}
}
