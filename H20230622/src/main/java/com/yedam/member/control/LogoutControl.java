package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Controller;

public class LogoutControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
//		session.removeAttribute("loginId");
//		session.removeAttribute("loginName");
		
		session.invalidate(); // 세션 객체 제거.
		
		resp.sendRedirect("memberLoginForm.do");

	}

}
