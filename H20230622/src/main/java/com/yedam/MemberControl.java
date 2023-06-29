package com.yedam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Controller;

public class MemberControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("member control입니다.");
	}

}
