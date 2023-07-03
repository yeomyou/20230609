package com.yedam.board.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceImpl;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class BoardDetailControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		BoardService service = new BoardServiceImpl(); 
		String brdNo = req.getParameter("brdNo");
		
		BoardVO vo = service.selectDetail(Integer.parseInt(brdNo));
		req.setAttribute("board", vo);
		return "board/boardDetail.tiles";
	}

}
