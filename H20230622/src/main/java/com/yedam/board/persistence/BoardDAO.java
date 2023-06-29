package com.yedam.board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.board.vo.BoardVO;
import com.yedam.common.DAO;

public class BoardDAO {
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

	// 목록, 단건조회, 등록, 수정, 삭제.
	public List<BoardVO> boardListPaging(int page) {
		sql = "select *\r\n"
				+ "from(\r\n"
				+ "        select rownum rn, a.*\r\n"
				+ "        from (\r\n"
				+ "                 select *\r\n"
				+ "                  from tbl_board order by brd_no desc\r\n"
				+ "                 ) a\r\n"
				+ "       )b\r\n"
				+ "where b.rn> (?- 1 ) * 10\r\n"
				+ "and b.rn<= ? * 10\r\n";
		conn = DAO.getConnect();
		
		List<BoardVO> brd = new ArrayList<>();

		
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, page);
			psmt.setInt(2, page);
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBrdNo(rs.getLong(2));
				vo.setBrdTitle(rs.getString(3));
				vo.setBrdWriter(rs.getString(4));
				vo.setBrdContent(rs.getString(5));
				vo.setCreateDate(String.valueOf(rs.getDate(6)));
				vo.setClickCnt(rs.getLong(7));

				brd.add(vo);
			}
			return brd;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	public boolean inserBoard(BoardVO vo) {
		sql = "insert into tbl_board (brd_no, brd_Title, brd_writer, brd_content) values(board_seq.nextval, ?, ?, ?)";
		conn = DAO.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBrdTitle());
			psmt.setString(2, vo.getBrdWriter());
			psmt.setString(3, vo.getBrdContent());

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
	//전체건수 계산.
	public int getTotalCnt() {
		sql = "select count(1) from tbl_board";
		conn = DAO.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			rs.next();
			int cnt = rs.getInt(1);
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	public boolean updateBoard(BoardVO vo) {
		sql = "update tbl_board set brd_title=?, brd_content=? where brd_no=?";
		conn = DAO.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBrdTitle());
			psmt.setString(2, vo.getBrdContent());
			psmt.setLong(3, vo.getBrdNo());
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

	public boolean deleteBoard(long brdNo) {
		sql = "delete from tbl_board where brd_no = ?";
		conn = DAO.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, brdNo);
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

	public BoardVO selectBoard(long brdNo) {
		sql = "select * from tbl_board where brd_no = ?";
		conn = DAO.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, brdNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBrdNo(rs.getLong(1));
				vo.setBrdTitle(rs.getString(2));
				vo.setBrdWriter(rs.getString(3));
				vo.setBrdContent(rs.getString(4));
				vo.setCreateDate(String.valueOf(rs.getDate(5)));
				vo.setClickCnt(rs.getLong(6));
				return vo;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}
	public void clickCount(long brdNo) {
		sql = "update tbl_board set click_cnt= click_cnt+1 where brd_no=?";
		conn = DAO.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, brdNo);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 변경");
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
}
