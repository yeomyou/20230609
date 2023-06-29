package com.yedam.common;

import java.util.ArrayList;
import java.util.List;

import com.yedam.board.persistence.BoardDAO;
import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;

public class TestMain {
	public static void main(String[] args) {
		BoardService service = new BoardServiceMybatis();
		
		PageDTO dto = new PageDTO(3, service.totalCnt());
		
		System.out.println(dto);
	}
}
