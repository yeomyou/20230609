package com.yedam.board.service;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> boardList();
	public BoardVO selectDetail(int brdNo);
}
