package com.yedam.member.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.yedam.common.Control;
import com.yedam.member.service.MemberServcieImpl;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("uid");
		String pw = req.getParameter("upw");
		
		MemberService service = new MemberServcieImpl();
		MemberVO result = service.login(id, pw);
		if(result == null) {
		return "loginForm.do";
		}
		HttpSession session = req.getSession(); 
		session.setAttribute("logId", result.getUserId());
		session.setAttribute("logName", result.getUserName());
		return "main.do";
	}

}
