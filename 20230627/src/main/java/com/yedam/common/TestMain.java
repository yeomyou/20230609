package com.yedam.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.board.dao.ReplyMapper;
import com.yedam.board.vo.ReplyVO;
import com.yedam.calendar.dao.CalendarMapper;
import com.yedam.calendar.vo.CalendarVO;
import com.yedam.member.dao.MemberMapper;

public class TestMain {
	public static void main(String[] args) {
		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		
//		ReplyVO VO = new ReplyVO();
//		VO.setReplyNo(15);
//		VO.setReply("bye");
//		
//		mapper.insertReply(insertVO);
//		mapper.deleteReply(1);
//		mapper.updateReply(VO);
		
		
		
//		ReplyVO reply = mapper.selectOne(4);
//		
//		System.out.println(reply.toString());
//		System.out.println("=============================");
//		List<ReplyVO> list = mapper.selectList(4);
//		for(ReplyVO vo : list) {
//			System.out.println(vo.toString());
//		}
//		
	}
}
