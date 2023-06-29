package com.yedam.member.control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Controller;
import com.yedam.member.persistence.MemberMapper;
import com.yedam.member.service.MemberSerivceImpl;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class MemberInfoControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//loginId.
		HttpSession session = req.getSession();
		
		String id = (String)session.getAttribute("loginId");
		//service(getMember) / mapper(select) / jsp 등록.
		MemberService service = new MemberSerivceImpl();
		MemberVO vo = new MemberVO();

		
		
		vo = service.getMember(id);
		
		req.setAttribute("info", vo);
		req.getRequestDispatcher("WEB-INF/jsp/member/memberInfo.jsp").forward(req, resp);
	
	}

}
