package com.yedam.board.service;

import java.util.List;

import com.yedam.board.vo.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> replyList(int brdNo, int page); //댓글목록
	public int replyCount(int brdNo);
	
	public ReplyVO getReply(int replyNo); // 댓글 한건 조회
	public boolean addReply(ReplyVO vo); // 등록.
	public boolean modifyReply(ReplyVO vo); // 수정.
	public boolean removeReply(int replyNo); // 삭제.
}
