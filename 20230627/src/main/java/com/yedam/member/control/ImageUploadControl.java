package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.member.service.MemberServcieImpl;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class ImageUploadControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String savePath = req.getServletContext().getRealPath("/images");
		String enc = "UTF-8";
		int maxSize = 1024 * 1024 * 10;
		String json ="";
		try {
			MultipartRequest multi = new MultipartRequest(req, savePath, maxSize, enc, new DefaultFileRenamePolicy());
			String id = multi.getParameter("id");
			
			String fileName = multi.getFilesystemName("image");//원래값X 리네임정책 후 값O
			
			MemberVO member = new MemberVO();
			member.setUserId(id);
			member.setUserImg(fileName);
			
			MemberService service = new MemberServcieImpl();
			
			if(service.modifyImage(member)) {
				// {"retCode":"Success", "path": "fileName" }
				// {"retCode":"Fail"}
				json = "{\"retCode\":\"Success\",\"path\":\""+fileName+"\"}";
			}else {
				json = "{\"retCode\":\"Fail\"}";
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return json + ".json";
	}

}
