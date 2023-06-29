package com.yedam.calendar.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.calendar.service.CalendarService;
import com.yedam.calendar.service.CalendarServiceImpl;
import com.yedam.calendar.vo.CalendarVO;
import com.yedam.common.Control;

public class AddEventControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		CalendarService service = new CalendarServiceImpl();
		CalendarVO vo = new CalendarVO();
		
		vo.setTitle(req.getParameter("title"));
		vo.setStartDate(req.getParameter("start"));
		vo.setEndDate(req.getParameter("end"));
		
		System.out.println(vo.toString());
		String json ="";
		if(service.addEvent(vo)) {
			// [{"retCode":"Success"}]
			json = "[{\"retCode\":\"Success\"}]";
		}else {
			json= "[{\"retCode\":\"Fail\"}]";
		}
		
		return json+".json";
	}

}
