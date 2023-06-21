package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.tblBoardVO;
import com.yedam.board.tblBoardDao;

@WebServlet("/boardAdd")
public class AddBoardServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		tblBoardVO board = new tblBoardVO();
		board.setBrdTitle(title);
		board.setBrdWriter(writer);
		board.setBrdContent(content);
		
		tblBoardDao dao = tblBoardDao.getInstance();
		boolean result = dao.insert(board);
		
		if(result) {
			resp.sendRedirect("board/blist.jsp");
		}else {
			resp.sendRedirect("board/add.jsp");
		}
	}
}
