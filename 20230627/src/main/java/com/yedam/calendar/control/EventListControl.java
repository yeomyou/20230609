package com.yedam.calendar.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.calendar.dao.CalendarMapper;
import com.yedam.calendar.service.CalendarService;
import com.yedam.calendar.service.CalendarServiceImpl;
import com.yedam.calendar.vo.CalendarVO;
import com.yedam.common.Control;

public class EventListControl implements Control {
	Gson gson = new GsonBuilder().create();
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		CalendarService service = new CalendarServiceImpl(); 
		List<CalendarVO> cal = service.events(); 
		//[{"title":"asd","start":"2023","end":"2023"}, . . . ]
		String json = gson.toJson(cal);
		return json+".json";
	}

}
