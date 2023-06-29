package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Controller;

public class LoginFormControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// WEB-INF/jsp/member
		req.getRequestDispatcher("WEB-INF/jsp/member/loginForm.jsp").forward(req, resp);
		
	}

}
