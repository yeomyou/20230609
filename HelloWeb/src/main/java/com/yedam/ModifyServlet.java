package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.tblBoardDao;
import com.yedam.board.tblBoardVO;
@WebServlet("/board/modify")
public class ModifyServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		tblBoardVO board = new tblBoardVO();
		board.setBrdNo(Integer.parseInt(no));
		board.setBrdTitle(title);
		board.setBrdContent(content);
		
		tblBoardDao dao = tblBoardDao.getInstance();
		dao.update(board);
		
		resp.sendRedirect("blist.jsp");

	}
}
