package com.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Controller;

public class BoardSearchControl implements Controller{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("bno");
		BoardService service = new BoardServiceMybatis();
		BoardVO vo = service.getBoard(Long.parseLong(no));
		
		req.setAttribute("board", vo);
		
		req.getRequestDispatcher("WEB-INF/jsp/boardOne.jsp").forward(req, resp);
		
	}

}
