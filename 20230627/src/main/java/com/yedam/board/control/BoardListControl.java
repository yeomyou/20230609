package com.yedam.board.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceImpl;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;
import com.yedam.common.PageDTO;

public class BoardListControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		BoardService service = new BoardServiceImpl(); 

		
		PageDTO dto = new PageDTO(Integer.parseInt(page), service.totalCnt());
		List<BoardVO> boards = service.boardList(Integer.parseInt(page));
		
		req.setAttribute("boards", boards);
		req.setAttribute("page", dto);
		
		
		
		//
		
		
		return "board/boardList.tiles";
	}

}
