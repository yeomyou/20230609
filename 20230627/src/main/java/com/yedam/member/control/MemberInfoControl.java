package com.yedam.member.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.member.service.MemberServcieImpl;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class MemberInfoControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		/*
		 * getMember(id)= service,  infoSelect(id)=mapper => MemberVO
		 * admin/memberInfo.jsp
		 */
		
		MemberService service = new MemberServcieImpl();
		MemberVO member = service.getMember(req.getParameter("uid"));
		req.setAttribute("member", member);
		return "admin/memberInfo.tiles";
	}

}
