package com.yedam.board.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.board.service.ReplyService;
import com.yedam.board.service.ReplyServiceImpl;
import com.yedam.board.vo.ReplyVO;
import com.yedam.common.Control;

public class ReplyListControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> map = new HashMap<>();
		
		String brdNo = req.getParameter("brdNo");
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		
		ReplyService service = new ReplyServiceImpl();
		List<ReplyVO> reply = service.replyList(Integer.parseInt(brdNo), Integer.parseInt(page));
		int totalCount = service.replyCount(Integer.parseInt(brdNo));
		
		map.put("list", reply);
		map.put("count", totalCount);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		return json+".json";
	}

}
