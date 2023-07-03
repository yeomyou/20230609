package com.yedam.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.board.vo.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> selectList(@Param("brdNo") int brdNo, @Param("page") int page); //댓글목록
	public int selectCount(int brdNo);
	public ReplyVO selectOne(int replyNo); // 댓글 한건 조회
	public int insertReply(ReplyVO vo); // 등록.
	public int updateReply(ReplyVO vo); // 수정.
	public int deleteReply(int replyNo); // 삭제.
}
