package com.yedam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Controller;

public class MainControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//boardList.jsp
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		rd.forward(req, resp);
	}

}
	