package com.yedam;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.ProductListControl;
import com.yedam.control.ProductSelectControl;

public class FrontController extends HttpServlet{
private HashMap<String, Control> menu;
	
	public FrontController() {
		menu = new HashMap<>();
	}
	
	@Override
	public void init() throws ServletException {
			menu.put("/productList.do", new ProductListControl());
			menu.put("/prodInfo.do", new ProductSelectControl());
	
	
	
	
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String page = uri.substring(contextPath.length());
		System.out.println(page);
		
		Control control = menu.get(page);
		String viewPage = control.exec(req, resp);
		System.out.println(viewPage);
		
	
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}
}
