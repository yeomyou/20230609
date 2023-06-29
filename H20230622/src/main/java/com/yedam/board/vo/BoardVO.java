package com.yedam.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BoardVO {
	private long brdNo;
	private String brdTitle;
	private String userName;
	private String brdWriter;
	private String brdContent;
	private String createDate;
	private long clickCnt;
}
