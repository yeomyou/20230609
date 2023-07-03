package com.yedam.member.service;

import java.util.List;
import java.util.Map;

import com.yedam.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> members();
	public MemberVO login(String id, String pw);
	public List<Map<String, Object>> getData();
	public MemberVO getMember(String id);
	public boolean modifyMember(MemberVO member);
	public boolean modifyImage(MemberVO member);
	public boolean addMember(MemberVO member);
}
