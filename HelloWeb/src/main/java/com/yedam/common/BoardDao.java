package com.yedam.common;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BoardDao {
	private static BoardDao instance = new BoardDao();

	public BoardDao() {
	}

	public static BoardDao getInstance() {
		return instance;
	}

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	private void close() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (Exception e) {

		}
	}

	// 작성하기
	public void write(BoardVO board) {
		sql = "insert into board (b_no, b_title, b_content, id) values (b_seq.nextval, ?, ?, ?)";

		conn = Dao.getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getId());

			int r = psmt.executeUpdate();
			if (r > 0) {
				System.out.println("등록 완료");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println("등록 실패");
		return;
	}

	// 삭제하기
	public boolean delete(int no, String id) {
		if (id.equals("admin")) {
			sql = "delete from board where b_no = ?";
		} else {
			sql = "delete from board where id =  ? AND b_no = ?";
		}
		conn = Dao.getConnect();

		try {
			psmt = conn.prepareStatement(sql);

			if (id.equals("admin")) {
				psmt.setInt(1, no);
			} else {
				psmt.setString(1, id);
				psmt.setInt(2, no);
			}
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	// 수정하기
	public void reWrite(String newTitle, String newContent, int no, String id) {
		if (id.equals("admin")) {
			sql = "update board set b_title = ? , b_content = ? where b_no = ?";
		} else {
			sql = "update board set b_title = ? , b_content = ? where b_no = ? AND id = ?";
		}
		conn = Dao.getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			if (id.equals("admin")) {
				psmt.setString(1, newTitle);
				psmt.setString(2, newContent);
				psmt.setInt(3, no);
			} else {
				psmt.setString(1, newTitle);
				psmt.setString(2, newContent);
				psmt.setInt(3, no);
				psmt.setString(4, id);
			}
			int r = psmt.executeUpdate();
			if (r > 0) {
				System.out.println("수정 완료");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println("수정 실패");
		return;

	}

	// 상세보기
	public boolean showDetail(int no) {
		sql = "select * from board where b_no = ?";
		String sql2 = "select  c.comments, c.id \r\n" + " FROM board b LEFT JOIN comm c ON c.b_no = b.b_no\r\n"
				+ " WHERE b.b_no = c.b_no AND b.b_no = ?";
		conn = Dao.getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);

			PreparedStatement psmt2 = conn.prepareStatement(sql2);
			psmt2.setInt(1, no);

			rs = psmt.executeQuery();
			ResultSet rs2 = psmt2.executeQuery();

			BoardVO board = new BoardVO();
			while (rs.next()) {
				board.setNo(Integer.parseInt(rs.getString(1)));
				board.setTitle(rs.getString(2));
				board.setContent(rs.getString(3));
				board.setId(rs.getString(4));
				board.setDate(rs.getString(5));
			}
			if (board.getNo() == 0) {
				return false;
			}
			System.out.println(board.toString());
			System.out.println("====================================\nComments =>");
			HashMap<String, String> comments = new HashMap<>();
			while (rs2.next()) {
				comments.put(rs2.getString(1), rs2.getString(2));

			}
			for (String a : comments.keySet()) {
				System.out.println("Comment : " + a + "\t작성자 : " + comments.get(a));
			}
			if (rs.next() == false && rs2.next() == false) {
				System.out.println("last Of page.");
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println("상세보기 실패");
		return false;
	}

	public List<BoardVO> showList() {
		sql = "select b_no, b_title, id, b_date from board order by 1";
		conn = Dao.getConnect();
		List<BoardVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO boards = new BoardVO();
				boards.setNo(Integer.parseInt(rs.getString(1)));
				boards.setTitle(rs.getString(2));
				boards.setId(rs.getString(3));
				boards.setDate(rs.getString(4));

				list.add(boards);
			}
			return list;
		} catch (SQLException e) {

		} finally {
			close();
		}
		return null;
	}

	public void writeComment(String comm, String id, int no) {
		sql = "INSERT INTO COMM values(?, ?, ?)";
		conn = Dao.getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, comm);
			psmt.setString(2, id);
			psmt.setInt(3, no);
			int r = psmt.executeUpdate();
			if (r > 0) {
				System.out.println("댓글 작성 완료");
			} else {
				System.out.println("댓글 작성 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void likeBoard(String id, int boardNo) {
		// on and off 조회 쿼리 1개, update 쿼리 1개 추가 및 조건부 실행 코드
		String DupliCheckSql = " select id from like_board where id = ? AND b_no = ?";
		// id(현재 로그인 유저)가 b_no(상세보기한 글의 번호)를 Like_board에서 즐겨찾기한 적이 있는가? 있으면 출력 아니면 X
		String updateSql = " update like_board set onandoff = onandoff+1 where id = ? AND b_no = ?";
		// 있으면 수정.
		String insertSql = "insert into like_board values(?,?,?)";
		// 없으면 초기 생성

		sql = " ";

		conn = Dao.getConnect();
		PreparedStatement updatePsmt;
		PreparedStatement insertPsmt;

		try {
			psmt = conn.prepareStatement(DupliCheckSql);
			psmt.setString(1, id);
			psmt.setInt(2, boardNo);
			rs = psmt.executeQuery();

			if (rs.next()) { // 쿼리 결과가 있으면~
				updatePsmt = conn.prepareStatement(updateSql);
				updatePsmt.setString(1, id);
				updatePsmt.setInt(2, boardNo);
				int updateR = updatePsmt.executeUpdate();
				if (updateR > 0) {
					System.out.println("즐겨찾기 업데이트 성공");
					return;
				}
			} else {
				insertPsmt = conn.prepareStatement(insertSql);
				insertPsmt.setString(1, id);
				insertPsmt.setInt(2, boardNo);
				insertPsmt.setInt(3, 1);
				int insertR = insertPsmt.executeUpdate();
				if (insertR > 0) {
					System.out.println("즐겨찾기 등록 성공");
					return;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println("즐겨찾기 등록 실패");
	}

	public void favorList(String id) {
		sql = "select b_no , b_title,  id, b_date, b_content from board where b_no IN (select b_no from like_board where MOD(onandoff,2) = 1 AND id = ?) ORDER BY 1";
		conn = Dao.getConnect();
		System.out.println("========즐겨찾기  목록========");
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			BoardVO favorBoard = new BoardVO();
			while (rs.next()) {
				favorBoard.setNo(rs.getInt(1));
				favorBoard.setTitle(rs.getString(2));
				favorBoard.setId(rs.getString(3));
				favorBoard.setDate(rs.getString(4));
				favorBoard.setContent(rs.getString(5));

				System.out.println(favorBoard.toString());
			}
			System.out.println("===========================");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
