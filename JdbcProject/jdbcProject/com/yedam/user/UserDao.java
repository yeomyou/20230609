package jdbcProject.com.yedam.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jdbcProject.com.yedam.Dao;

public class UserDao {
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

	public boolean add(UserVo user) {
		sql = "insert into tbl_users (user_id, user_pw, user_name) values (?,?,?)";
		conn = Dao.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserPw());
			psmt.setString(3, user.getUserName());

			int r = psmt.executeUpdate(); // 쿼리 실행
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

	public boolean modify(UserVo user) {
		sql = "update tbl_users set user_pw = nvl(?,user_pw), user_name = nvl(?,user_name),"//
				+ "user_birth = nvl(?,user_birth), user_phone = nvl(?,user_phone), user_addr = nvl(?,user_addr) where user_id = ?";

		conn = Dao.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserPw());
			psmt.setString(2, user.getUserName());
			psmt.setString(3, user.getUserBirth());
			psmt.setString(4, user.getUserPhone());
			psmt.setString(5, user.getUserAddr());
			psmt.setString(6, user.getUserId());

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

	public UserVo search(String id) {
		sql = "select * from tbl_users where user_id = ?";
		conn = Dao.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				UserVo user = new UserVo();
				user.setUserId(rs.getString("user_id"));
				user.setUserPw(rs.getString("user_pw"));
				user.setUserName(rs.getString("user_name"));
				user.setUserBirth(rs.getString("user_birth"));
				user.setUserPhone(rs.getString("user_phone"));
				user.setUserAddr(rs.getString("user_addr"));
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}
	
	public boolean delete(String id) {
		sql = "delete from tbl_users where user_id = ?";
		conn = Dao.getConnect();
		try {
//			conn.setAutoCommit(false);
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}
	
	public List<UserVo> list(){
//		List<UserVo> list = new ArrayList<>();
//		sql = "select * from tbl_users";
//		
//		conn = Dao.getConnect();
//		int k = 1;
//		try {
//			psmt = conn.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			
//			while(rs.next()) {
//				Object justUser = rs.getObject(k);
//				UserVo user = (UserVo)justUser;
//				list.add(user);
//				k++;
//			}
//		}
//		catch(SQLException e ) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		return list;
//		Object로 값 받기.
		
		List<UserVo> list = new ArrayList<>();
		sql = "select * from tbl_users";
		
		conn = Dao.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				UserVo user = new UserVo();
				user.setUserId(rs.getString(1));
				user.setUserPw(rs.getString(2));
				user.setUserName(rs.getString(3));
				user.setUserBirth(rs.getString(4));
				user.setUserPhone(rs.getString(5));
				user.setUserAddr(rs.getString(6));
				
				list.add(user);
			
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	public boolean login(String id, String pw) {
		sql = "select * from tbl_users where user_id = ? and user_pw=?";
		conn = Dao.getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}finally {
			close();
		}
		return false;
	}

}
