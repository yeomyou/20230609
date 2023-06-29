package com.yedam.board.service;

import java.util.List;

import com.yedam.board.vo.BoardVO;

//등록, 조회, 수정, 삭제, 목록...
public interface BoardService {
	public boolean addBoard(BoardVO vo);
	public BoardVO getBoard(long brdNo);
	public boolean editBoard(BoardVO vo);
	public boolean delBoard(long brdNo);
	public List<BoardVO> list(int page);
	public int totalCnt();
}
