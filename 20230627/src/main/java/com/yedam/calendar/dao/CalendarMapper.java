package com.yedam.calendar.dao;

import java.util.List;

import com.yedam.calendar.vo.CalendarVO;

public interface CalendarMapper {
	public List<CalendarVO> getList();
	public int insert(CalendarVO vo);
	public int delete(CalendarVO vo);
}
