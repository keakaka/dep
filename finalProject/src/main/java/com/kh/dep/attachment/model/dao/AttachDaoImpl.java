package com.kh.dep.attachment.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.attachment.model.vo.Attachment;
import com.kh.dep.board.model.vo.Board;

@Repository
public class AttachDaoImpl implements AttachDao {

	@Override
	public int insertAttachment(SqlSessionTemplate sqlSession, Attachment file) {
		
		
		return sqlSession.insert("Member.insertAttach", file);
	}

	@Override
	public int insertBoardAttach(SqlSessionTemplate sqlSession, Attachment file) {
		
		return sqlSession.insert("Board.insertBoardAttach", file);
	}

	@Override
	public ArrayList<Attachment> selectDownloadList(SqlSessionTemplate sqlSession, Board b) {
		
		return (ArrayList)sqlSession.selectList("Board.selectDownList", b);
	}

	
}
