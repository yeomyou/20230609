package jdbcProject.com.yedam.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbcProject.com.yedam.Dao;

public class BoardDao {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	public instance getInstance() {
		
	}
	//"1.글등록  2.삭제  3.글 내용수정 4.글목록 보기 5.상세보기 6.종료."
	
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
	public boolean write(BoardVO boards) {
		sql = "insert into tbl_board (brd_no, brd_title, brd_content, brd_writer) values (board_seq.nextval,?, ?, ?)";
		conn = Dao.getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, boards.getBrdTitle());
			psmt.setString(2, boards.getBrdContent());
			psmt.setString(3, boards.getBrdWriter());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				System.out.println("글이 정상적으로 등록되었습니다.");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}
	public boolean delete(int brd_no) {
		sql = "delete from tbl_board where brd_no = ?";
		conn = Dao.getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,  String.valueOf(brd_no));
		
			int r = psmt.executeUpdate();
			if(r>0) {
				System.out.println("글이 정상적으로 삭제되었습니다.");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
		
	}
	public boolean reWrite(int brd_no, String newContent) {
		sql = "update tbl_board set brd_content = ? where brd_no = ?";
		conn = Dao.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, newContent);
			psmt.setString(2, String.valueOf(brd_no));
			
			int r = psmt.executeUpdate();
			if(r>0) {
				System.out.println("글이 정상적으로 수정되었습니다.");
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}
	public List<BoardVO> showBoard() {
		sql = "select brd_no, brd_title from tbl_board";
		conn = Dao.getConnect();
		List<BoardVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BoardVO boards = new BoardVO();
				boards.setBrdNo(Integer.parseInt(rs.getString(1)));
				boards.setBrdTitle(rs.getString(2));
				
				list.add(boards);
			}
			return list;
		}catch (SQLException e) {
			
		}finally {
			close();
		}
		return null;
	}
	public BoardVO showContent(int no) {
		String sql2 = "update tbl_board set click_cnt = click_cnt+1 where brd_no = ?";
		sql = "SELECT * FROM tbl_board where brd_no = ?";
		conn = Dao.getConnect();
		PreparedStatement psmt2 = null;
		try {
			psmt2 = conn.prepareStatement(sql2);
			psmt2.setString(1, String.valueOf(no));
			int r = psmt2.executeUpdate();
			//클릭 수 올리기
			
			
			//
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, String.valueOf(no));
			rs = psmt.executeQuery();
			// resultSet로 정보 가져오기
			BoardVO thisBoard = new BoardVO();
			while(rs.next()) {
			thisBoard.setBrdNo(Integer.parseInt(rs.getString(1)));
			thisBoard.setBrdTitle(rs.getString(2));
			thisBoard.setBrdContent(rs.getString(3));
			thisBoard.setBrdWriter(rs.getString(4));
			thisBoard.setCreDate(rs.getString(5));
			thisBoard.setClickCnt(Integer.parseInt(rs.getString(6)));
			}
			return thisBoard;
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close();
			try {
			if (psmt2 != null) {
				psmt2.close();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}
	

	
}
