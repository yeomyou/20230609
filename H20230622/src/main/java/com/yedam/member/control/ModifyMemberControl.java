package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Controller;
import com.yedam.member.service.MemberSerivceImpl;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class ModifyMemberControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// id, phone, addr
		HttpSession session = req.getSession();
		
		String id = (String) session.getAttribute("loginId");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		
		MemberVO member = new MemberVO();
		
		member.setUserId(id);
		member.setUserPhone(phone);
		member.setUserAddr(addr);
		
		MemberService service = new MemberSerivceImpl();
		service.modifyMember(member);
				
		//service(modifyMember) / mapperd(update)/ jsp게시글로 이동 
		resp.sendRedirect("boardList.do");
	}

}
