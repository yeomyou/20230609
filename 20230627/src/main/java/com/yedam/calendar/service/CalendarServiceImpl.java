package com.yedam.calendar.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.calendar.dao.CalendarMapper;
import com.yedam.calendar.vo.CalendarVO;
import com.yedam.common.DataSource;

public class CalendarServiceImpl implements CalendarService{
	SqlSession session = DataSource.getInstance().openSession(true);
	CalendarMapper mapper = session.getMapper(CalendarMapper.class);
	@Override
	public List<CalendarVO> events() {
		return mapper.getList();
	}

	@Override
	public boolean addEvent(CalendarVO vo) {
		return mapper.insert(vo)==1;
	}

	@Override
	public boolean removeEvent(CalendarVO vo) {
		return mapper.delete(vo)==1;
	}

}
