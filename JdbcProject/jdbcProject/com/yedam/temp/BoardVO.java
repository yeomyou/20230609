package jdbcProject.com.yedam.temp;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
	private int brdNo;
	private String brdTitle;
	private String brdWriter;
	private String brdContent;
	private Date createDate;
	private int clickCnt;

	public BoardVO(int brdNo, String brdContent) {
		this.brdNo = brdNo;
		this.brdContent = brdContent;
	}

	public BoardVO(String brdTitle, String brdWriter, String brdContent) {
		this.brdTitle = brdTitle;
		this.brdWriter = brdWriter;
		this.brdContent = brdContent;
	}

	public String briefInfo() {
		return "글번호: " + brdNo //
				+ ", 작성자: " + brdWriter//
				+ ", 제목: " + brdTitle //
				+ ", 조회수: " + clickCnt;
	}

	public String detailInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String msg = "글번호: " + brdNo + " 제목: " + brdTitle + " \n"//
				+ "조회수: " + clickCnt + " 작성일자: " + sdf.format(createDate) + " \n"//
				+ "내용: " + brdContent + " \n"//
				+ "작성자: " + brdWriter + "\n";
		return msg;
	}
}
