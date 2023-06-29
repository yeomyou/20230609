package com.yedam.board.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Controller;
import com.yedam.common.PageDTO;

public class BoardListControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		BoardService service = new BoardServiceMybatis();
		
		PageDTO dto = new PageDTO(Integer.parseInt(page), service.totalCnt());
		List<BoardVO> list = service.list(Integer.parseInt(page));
		
		req.setAttribute("list", list);
		req.setAttribute("page", dto);
		
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp");
		rd.forward(req, resp);
	}

}
