package com.yedam;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletContextTest1")
public class ServletContextTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ServletContextTest1() {
        super();
    }
  
    //ServletContext -> 생성자 -> ServletConfig -> init()-> service();
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	ServletContext sc = config.getServletContext(); //ServletContext 객체 환
    	sc.setAttribute("servletContext", "Hello");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
