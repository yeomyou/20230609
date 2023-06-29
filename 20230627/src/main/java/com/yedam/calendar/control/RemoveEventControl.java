package com.yedam.calendar.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.calendar.service.CalendarService;
import com.yedam.calendar.service.CalendarServiceImpl;
import com.yedam.calendar.vo.CalendarVO;
import com.yedam.common.Control;

public class RemoveEventControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		CalendarService service = new CalendarServiceImpl();
		CalendarVO vo = new CalendarVO();
		
		vo.setTitle(req.getParameter("title"));

		
		System.out.println(vo.toString());
		String json ="";
		if(service.removeEvent(vo)) {
			// [{"retCode":"Success"}]
			json = "[{\"retCode\":\"Success\"}]";
		}else {
			json= "[{\"retCode\":\"Fail\"}]";
		}
		/* Map 형식 , Gson 활용 json 리턴.
		 * Map<String,String> map = new HashMap<>();
		 * map.put("retCode","Success");
		 * map.put("retCode","Fail");
		 * Gson gson = new GsonBuilder().create();
		 * String json = gson.toJson(map) + ".json";
		 * return json;
		*/
		return json+".json";
	}

}
