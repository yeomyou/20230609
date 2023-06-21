package com.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.Dao;


public class tblBoardDao {

	private static tblBoardDao instance = new tblBoardDao();

	public tblBoardDao() {
	}

	public static tblBoardDao getInstance() {
		return instance;
	}

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql;

	// 추가.
	public boolean insert(tblBoardVO board) {
		conn = Dao.getConnect();
		sql = "insert into tbl_board (brd_no, brd_title, brd_content, brd_writer) "//
				+ "values (board_seq.nextval, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getBrdTitle());
			psmt.setString(2, board.getBrdContent());
			psmt.setString(3, board.getBrdWriter());
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

	// 수정.
	public boolean update(tblBoardVO board) {
		conn = Dao.getConnect();
		sql = "update tbl_board set brd_content=nvl(?, brd_content) where brd_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getBrdContent());
			psmt.setInt(2, board.getBrdNo());
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

	// 삭제.
	public boolean delete(int no) {
		conn = Dao.getConnect();
		sql = "delete from tbl_board where brd_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
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

	// 단건조회.
	public tblBoardVO select(int no) {
		conn = Dao.getConnect();
		sql = "select * from tbl_board where brd_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);

			rs = psmt.executeQuery();
			if (rs.next()) {
				tblBoardVO board = new tblBoardVO();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdContent(rs.getString("brd_content"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdWriter(rs.getString("brd_writer"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setCreateDate(rs.getDate("create_date"));

				return board;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	public void updateCnt(int no) {
		conn = Dao.getConnect();
		sql = "update tbl_board set click_cnt = click_cnt + 1 " + "where brd_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 목록.
	public List<tblBoardVO> list() {
		conn = Dao.getConnect();
		sql = "select * from tbl_board ";
		List<tblBoardVO> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				tblBoardVO board = new tblBoardVO();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdContent(rs.getString("brd_content"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdWriter(rs.getString("brd_writer"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setCreateDate(rs.getDate("create_date"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

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
			e.printStackTrace();
		}
	}
}
