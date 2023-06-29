package com.yedam.member.persistence;

import org.apache.ibatis.annotations.Param;

import com.yedam.member.vo.MemberVO;

public interface MemberMapper {
	public MemberVO login(@Param("id") String id , @Param("pw") String pw);
	public int insert(MemberVO member);
	public MemberVO select(String id);
	public int update(MemberVO member);
}
