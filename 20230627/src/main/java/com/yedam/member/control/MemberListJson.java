package com.yedam.member.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class MemberListJson implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		MemberService service = new MemberServiceImpl();
		List<MemberVO> list = service.members();
		Gson gson = new GsonBuilder().create();
		
		return gson.toJson(list)+".json";
	}


}
