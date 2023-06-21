package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.tblBoardDao;
import com.yedam.board.tblBoardVO;
import com.yedam.common.*;

@WebServlet("/prod/second")
public class SecondServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter(); //출력 스트림. (웹브라우저)/
		out.print("<h3>hello, world</h3>");
		
		
		out.print("<ul>");
		tblBoardDao dao = tblBoardDao.getInstance();
		List<tblBoardVO> list = dao.list();
		for(tblBoardVO volist : list) {
			out.print("<li>게시글 ㅣ " + volist.getBrdTitle()+"</li>");
			
		}
		out.print("</ul>");
		out.close();
		
		
	}
}
