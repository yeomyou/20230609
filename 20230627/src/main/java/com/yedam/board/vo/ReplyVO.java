package com.yedam.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int replyNo;
	private int brdNo;
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
}
