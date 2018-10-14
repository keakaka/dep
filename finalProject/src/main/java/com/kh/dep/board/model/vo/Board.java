package com.kh.dep.board.model.vo;

import org.springframework.stereotype.Repository;

@Repository
public class Board implements java.io.Serializable {
	
	
	private int boardNo;
	private int empNo;
	private String boardTitle;
	private String boardContent;
	private String boardType;
	private int selectCount;
	private String status;
	
	
	public Board(){}


	public Board(int boardNo, int empNo, String boardTitle, String boardContent, String boardType, int selectCount,
			String status) {
		super();
		this.boardNo = boardNo;
		this.empNo = empNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardType = boardType;
		this.selectCount = selectCount;
		this.status = status;
	}


	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", empNo=" + empNo + ", boardTitle=" + boardTitle + ", boardContent="
				+ boardContent + ", boardType=" + boardType + ", selectCount=" + selectCount + ", status=" + status
				+ "]";
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public int getEmpNo() {
		return empNo;
	}


	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	public String getBoardTitle() {
		return boardTitle;
	}


	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	public String getBoardContent() {
		return boardContent;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public String getBoardType() {
		return boardType;
	}


	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}


	public int getSelectCount() {
		return selectCount;
	}


	public void setSelectCount(int selectCount) {
		this.selectCount = selectCount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
