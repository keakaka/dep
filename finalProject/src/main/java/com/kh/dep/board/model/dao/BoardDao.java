package com.kh.dep.board.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.board.model.vo.Board;

public interface BoardDao {

	ArrayList<Board> selectBoardList(SqlSessionTemplate sqlSession);

	Board selectOneBoard(SqlSessionTemplate sqlSession,int bid);

}
