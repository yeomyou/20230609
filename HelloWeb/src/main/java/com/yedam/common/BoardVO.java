package com.yedam.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO implements Serializable{
	private int no;
	private String title;
	private String content;
	private String id;
	private String date;
	
	public BoardVO(int no, String title, String content, String id) {
		this.no = no;
		this.content = content;
		this.title = title;
		this.id = id;
	}
	@Override
	public String toString(){
	
		return "No."+no+"|\t\t|작성자 :"+this.id+"\t\t|제목: "+this.title+"\t\t|작성날짜: "+this.date+"\n"+"내용>"+this.content;
	}

}

