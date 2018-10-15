package com.kh.dep.board.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.board.model.vo.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Override
	public ArrayList<Board> selectBoardList(SqlSessionTemplate sqlSession) {
		
		
		return (ArrayList)sqlSession.selectList("Board.selectBoardList");
	}

	@Override
	public Board selectOneBoard(SqlSessionTemplate sqlSession, String bid) {
		
		
		
		return sqlSession.selectOne("Board.selectOneBoard", bid);
	}

}
