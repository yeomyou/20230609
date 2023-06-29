package com.yedam.member.service;

import com.yedam.member.vo.MemberVO;
// 인터페이스 - 구현객체, ( jdbc, mybatis )
public interface MemberService {
	public MemberVO login(String id, String pw);
	public boolean addMember(MemberVO member);
	public MemberVO getMember(String id);
	public boolean modifyMember(MemberVO member);
}
