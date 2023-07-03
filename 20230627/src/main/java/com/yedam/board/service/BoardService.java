package com.yedam.board.service;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> boardList(int page);
	public BoardVO selectDetail(int brdNo);
	public int clickCnt();
	public int totalCnt();
	
}
