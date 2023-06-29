package com.yedam.calendar.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class EventForm implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		return "prod/calendar.jsp";
		
	}

}
