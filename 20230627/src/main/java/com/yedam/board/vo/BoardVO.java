package com.yedam.board.vo;

import lombok.Data;

@Data
public class BoardVO {
	private int brdNo;
	private String brdTitle;
	private String brdWriter;
	private String brdContent;
	private String createDate;
	private int clickCnt;
}
