package com.yedam.board.dao;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardMapper {
	public List<BoardVO> boardList(int page);
	public BoardVO detail(int brdNo);
	public int clickCnt(); 
	public int totalCnt();
	}
