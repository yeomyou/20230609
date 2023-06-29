package com.yedam.member.control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Controller;
import com.yedam.member.service.MemberSerivceImpl;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class AddMemberControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//생성자: 1)요청정보 2)저장경로 3)최대파일크기 4)인코딩 5)리네임정책.
		String savePath = req.getServletContext().getRealPath("/imgs");
		int maxSize = 1024 * 1024 *  10; //10Mbytes
		String enc = "UTF-8";
		
		MultipartRequest multi = new MultipartRequest(req, savePath, maxSize, enc, new DefaultFileRenamePolicy());
		
		String id = multi.getParameter("uid");
		String pw = multi.getParameter("upw");
		String name = multi.getParameter("uname");
		String birth = multi.getParameter("ubirth");
		//multipart에서 가져오는 것은 전부 String 타입이므로 DateFormat으로 변경.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String img = multi.getFilesystemName("img");
		
		MemberVO vo = new MemberVO();
		vo.setUserId(id);
		vo.setUserPw(pw);
		vo.setUserName(name);
		try {
			vo.setUserBirth(sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		vo.setUserImg(img);
		
		//service -> serviceimpl
		//mapper -> mapper.xml
		MemberService service = new MemberSerivceImpl();
		if(service.addMember(vo)) {
			resp.sendRedirect("boardList.do");
		}else {
			resp.sendRedirect("memberJoinForm.do");
		}
	}

}
