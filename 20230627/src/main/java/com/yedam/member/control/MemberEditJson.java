package com.yedam.member.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class MemberEditJson implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		MemberService service = new MemberServiceImpl();

		String id = req.getParameter("uid");
		String pw = req.getParameter("upw");
		String ad = req.getParameter("uad");
		String ph = req.getParameter("uph");
		MemberVO member = new MemberVO();
		
		member.setUserId(id);
		member.setUserPw(pw);
		member.setUserAddr(ad);
		member.setUserPhone(ph);
		System.out.println(member.toString());
		
		Gson gson = new GsonBuilder().create();
		String json = "";
		if(service.modifyMember(member)) {
			 json = gson.toJson(member);
		}
		System.out.println(json);
		return json+".json";
	}

}
