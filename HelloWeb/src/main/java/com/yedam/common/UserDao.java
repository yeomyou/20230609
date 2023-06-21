package com.yedam.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class UserDao {
	
	private static UserDao instance = new UserDao();

	public UserDao() {
	}

	public static UserDao getInstance() {
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
	//회원가입.
	public boolean dupliCheck(String id) {
		sql = "select id from users where id = ?";
		conn = Dao.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			String dupliIdCheck;
			while(rs.next()) {
				dupliIdCheck = rs.getString(1);
				if(id.equals(dupliIdCheck)){
					return false;
				}
			}//1. 조회된 결과가 있다 => 중복
			// 2. 조회된 결과가 없다 => 가능 but,,SQL 오류
			// 3. 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return true;
	}
	
	public boolean userAdd(UserVO user) {
		//중복있는지 체크.
		sql = "insert into users (id, pw) values (?,?)";
		conn = Dao.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserPw());

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
	//로그인
	public boolean login(String id, String pw) {
		sql = "select id from users where id = ? and pw = ?";
		conn = Dao.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			
			return rs.next();
			//
		}catch(SQLException e) {
			
		}finally {
			close();
		}
		return false;
	}
	
}
