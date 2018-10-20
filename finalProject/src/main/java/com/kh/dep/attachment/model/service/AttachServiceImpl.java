package com.kh.dep.attachment.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dep.attachment.model.dao.AttachDao;
import com.kh.dep.attachment.model.dao.AttachDaoImpl;
import com.kh.dep.attachment.model.vo.Attachment;
import com.kh.dep.board.model.vo.Board;


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

	@Override
	public int insertBoardAttach(Attachment file) {
		
		int result = ad.insertBoardAttach(sqlSession, file);
		
		return result;
	}

	@Override
	public ArrayList<Attachment> selectDownloadList(Board b) {
		
		ArrayList<Attachment> atlist = null;
		
		atlist = ad.selectDownloadList(sqlSession, b);
		
		return atlist;
	}
	
	

}
