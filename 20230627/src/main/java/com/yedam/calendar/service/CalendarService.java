package com.yedam.calendar.service;

import java.util.List;

import com.yedam.calendar.vo.CalendarVO;

public interface CalendarService {
	List<CalendarVO> events();
	public boolean addEvent(CalendarVO vo);
	public boolean removeEvent(CalendarVO vo);
}
