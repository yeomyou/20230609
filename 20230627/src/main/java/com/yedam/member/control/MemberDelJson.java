package com.yedam.member.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class MemberDelJson implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		MemberService service = new MemberServiceImpl();
		
		MemberVO member = new MemberVO();
		String id = req.getParameter("uid");
		member.setUserId(id);
		Map<String, String> map = new HashMap<>();
		Gson gson = new GsonBuilder().create();
		String json = "";
		if(service.delMember(member)) {
			map.put("retCode", "Success");
		}else {
			map.put("retCode", "Fail");
		}
		json = gson.toJson(map);
		
		return json+".json";
	}

}
