package com.kh.dep.attachment.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dep.attachment.model.dao.AttachDao;
import com.kh.dep.attachment.model.dao.AttachDaoImpl;
import com.kh.dep.attachment.model.vo.Attachment;


@Service
public class AttachServiceImpl implements AttachService {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private AttachDao ad;

	@Override
	public int insertAttachment(Attachment file) {
		
		int result = ad.insertAttachment(sqlSession, file);
		
		return result;
	}
	
	

}
