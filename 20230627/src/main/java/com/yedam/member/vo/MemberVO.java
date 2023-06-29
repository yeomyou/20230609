package com.yedam.member.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String userId;
	private String userPw;
	private String userName;
	private Date userBirth;
	private String userPhone;
	private String userAddr;
	private String userImg; 
}
