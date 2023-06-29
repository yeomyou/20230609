package com.yedam.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.calendar.dao.CalendarMapper;
import com.yedam.calendar.vo.CalendarVO;
import com.yedam.member.dao.MemberMapper;

public class TestMain {
	public static void main(String[] args) {
		SqlSession session = DataSource.getInstance().openSession(true);
		CalendarMapper mapper = session.getMapper(CalendarMapper.class);
		CalendarVO test = new CalendarVO();
		
		test.setTitle("여행가기2");
		
		mapper.delete(test);
//		
//		test.setTitle("여행가기2");
//		test.setStartDate("2023-06-05");
//		test.setEndDate("");
		
//		mapper.insert(test);
		List<CalendarVO> list = mapper.getList();
		
		for(CalendarVO vo : list) {
			System.out.println(vo.toString());
			
			
		}
		
	}
}
