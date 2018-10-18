package com.kh.dep.board.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dep.board.exception.BoardException;
import com.kh.dep.board.model.dao.BoardDao;
import com.kh.dep.board.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private BoardDao bd;
	
	@Override
	public ArrayList<Board> selectBoardList() throws BoardException {
		
		ArrayList<Board> blist = null;
		
		blist = bd.selectBoardList(sqlSession);
		
		if(blist == null){
			throw new BoardException("게시판 목록 불러오기 실패");
		}
		
		return blist;
	}

	@Override
	public Board selectOneBoard(int bid) {
		
		Board b = null;
		
		b = bd.selectOneBoard(sqlSession, bid);
		
		return b;
	}

}
