package com.yedam;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	public FirstServlet() {
		System.out.println("생성자 호출");
	}
	//servlet life cycle : init() -> service() -> destroy()
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init 호출");//서버 실행 후 최초 1회 실행.
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("service 호출"); //서버 실행 후 요청이 있을 때마다 실행
	}
	@Override
	public void destroy() {
		System.out.println("destroy 호출"); // 서버 종료될 때 실행.
		super.destroy();
	}
	
}
