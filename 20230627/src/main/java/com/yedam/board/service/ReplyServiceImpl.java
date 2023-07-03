package com.yedam.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.board.dao.ReplyMapper;
import com.yedam.board.vo.ReplyVO;
import com.yedam.common.DataSource;

public class ReplyServiceImpl implements ReplyService{
	SqlSession session = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = session.getMapper(ReplyMapper.class);
	@Override
	public List<ReplyVO> replyList(int brdNo, int page) {
		return mapper.selectList(brdNo, page);
	}
	@Override
	public ReplyVO getReply(int replyNo) {
		return mapper.selectOne(replyNo);
	}
	@Override
	public boolean addReply(ReplyVO vo) {
		return mapper.insertReply(vo)==1;
	}
	@Override
	public boolean modifyReply(ReplyVO vo) {
		return mapper.updateReply(vo)==1;
	}
	@Override
	public boolean removeReply(int replyNo) {
		return mapper.deleteReply(replyNo)==1;
	}
	@Override
	public int replyCount(int brdNo) {
		return mapper.selectCount(brdNo);
	}

}
