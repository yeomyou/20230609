package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/QueryTestServ", "/queryTest" })
public class QueryTestServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public QueryTestServ() {
        super();
    }

    //service 를 정의하지 않은경우
    //요청 방식에 따라 get방식이면 doGet() 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답정보 steam 기본, 영문,숫자 / 한글(x)
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		String hobbies[] = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String religion = request.getParameter("religion");
		String intro = request.getParameter("intro");
		
		//응답정보.
		PrintWriter out = response.getWriter();
		out.print("<p>ID: " + id + "</p>");
		out.print("<p>PW: " + pwd + "</p>");
		out.print("<p>이름: " + name + "</p>");
		for(String hobby : hobbies) {
			out.print("<p>취미: " + hobby + "</p>");
		}
		out.print("<p>성별: " + gender + "</p>");
		out.print("<p>종교: " + religion + "</p>");
		out.print("<p>소개: " + intro + "</p>");
		
		out.print("<p>QueryString : " + request.getQueryString() + "</p>");
		
	}
	//요청 방식에 따라 post방식이면 doPost()호출
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post방식 호출.");
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		Enumeration<String> enm = request.getHeaderNames();
		while(enm.hasMoreElements()) {
			String elem = enm.nextElement();
			System.out.println("header : " + elem + ", val : " + request.getHeader(elem));
		}
//		
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		String name = request.getParameter("name");
//		
//		String hobbies[] = request.getParameterValues("hobby");
//		String gender = request.getParameter("gender");
//		String religion = request.getParameter("religion");
//		String intro = request.getParameter("intro");
		
		//응답정보.
		PrintWriter out = response.getWriter();
//		out.print("<p>ID: " + id + "</p>");
//		out.print("<p>PW: " + pwd + "</p>");
//		out.print("<p>이름: " + name + "</p>");
//		for(String hobby : hobbies) {
//			out.print("<p>취미: " + hobby + "</p>");
//		}
//		out.print("<p>성별: " + gender + "</p>");
//		out.print("<p>종교: " + religion + "</p>");
//		out.print("<p>소개: " + intro + "</p>");
		
		out.print("<p>QueryString : " + request.getQueryString() + "</p>");
		
		//get방식의 쿼리스트링 post에서 가져오는 방식. -->
		ServletInputStream sis = request.getInputStream();
		int len = request.getContentLength();
		byte[] buf = new byte[len];
		sis.readLine(buf, 0, len);
		
		String queryString = new String(buf);
		out.print("<p>QeuryString: " + queryString + "</p>");
		
	}

}
