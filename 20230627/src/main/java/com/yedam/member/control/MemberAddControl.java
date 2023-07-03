package com.yedam.member.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class MemberAddControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		MemberService service = new MemberServiceImpl();
		//uid,upw,uname,ubi,uad,uph
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String uid = req.getParameter("uid");
		String upw = req.getParameter("upw");
		String uname = req.getParameter("uname");
		String uad = req.getParameter("uad");
		String uph = req.getParameter("uph");
		String tmpUbi = req.getParameter("ubi");
		Date ubi = null;
		try {
			ubi = format.parse(tmpUbi);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		MemberVO member = new MemberVO();
		
		member.setUserId(uid);
		member.setUserPw(upw);
		member.setUserName(uname);
		member.setUserBirth(ubi);
		member.setUserAddr(uad);
		member.setUserPhone(uph);
		member.setUserImg("");
		Gson gson = new GsonBuilder().create();
		String json = "";
		if(service.addMember(member)) {
			json = gson.toJson(member);
		}else {
			json = "";
		}
		
		
		
		return json+".json";
	}

}
