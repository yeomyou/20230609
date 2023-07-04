package com.yedam.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.member.vo.MemberVO;

public interface MemberMapper {
	public List<MemberVO> memberList();
	public MemberVO login(@Param("id") String id, @Param("pw") String pw);
	public int insert(MemberVO member);
	public MemberVO select(MemberVO member);
	public int update(MemberVO member);
	public List<Map<String,Object>> chartData();
	public MemberVO infoSelect(@Param("id")String id);
	public int modifyMember(MemberVO member);
	public int modifyImage(MemberVO member);
	public int delete(MemberVO member);
}
