package com.yedam.board.control;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.board.service.ReplyService;
import com.yedam.board.service.ReplyServiceImpl;
import com.yedam.board.vo.ReplyVO;
import com.yedam.common.Control;

public class AddReplyControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		ReplyService service = new ReplyServiceImpl();
		Gson gson = new GsonBuilder().create();
		//원본글 작성자 댓글내용
		String bno = req.getParameter("bno");
		String replyer = req.getParameter("replyer");
		String reply = req.getParameter("reply");
		
		ReplyVO vo = new ReplyVO();
		vo.setBrdNo(Integer.parseInt(bno));
		vo.setReplyer(replyer);
		vo.setReply(reply);
		vo.setReplyDate(new Date());
		String json = "";
		if(service.addReply(vo)) {
			json = gson.toJson(vo);
			json += ".json";
		}else {
		}
		return json;
	}
	
	//댓글 갯수 기준으로 페이지 계산.
	

}
