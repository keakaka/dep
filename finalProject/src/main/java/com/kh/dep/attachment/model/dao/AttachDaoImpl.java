package com.kh.dep.attachment.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.attachment.model.vo.Attachment;

@Repository
public class AttachDaoImpl implements AttachDao {

	@Override
	public int insertAttachment(SqlSessionTemplate sqlSession, Attachment file) {
		
		
		return sqlSession.insert("Member.insertAttach", file);
	}

	
}
