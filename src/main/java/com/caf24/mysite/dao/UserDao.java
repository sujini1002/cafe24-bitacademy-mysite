package com.caf24.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.mysite.vo.GuestBookVo;
import com.cafe24.mysite.vo.UserVo;

public class UserDao {
	public Boolean update(UserVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnetction();

			String sql = "update user set password=?,gender=? where no =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getGender());
			pstmt.setLong(3, vo.getNo());

			int cnt = pstmt.executeUpdate();
			result = cnt == 1 ? true : false;

		} catch (SQLException e) {
			System.out.println("errr=" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}

	public UserVo get(long no) {
		UserVo result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnetction();

			String sql = "select  no,name,email,password,gender from user where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);

			rs = pstmt.executeQuery();// pstmt 내부에 있으므로 sql문장을 넣어줄 필요 없다.

			while (rs.next()) {
				long userno = rs.getLong(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String password = rs.getString(4);
				String gender = rs.getString(5);

				result = new UserVo();
				result.setNo(userno);
				result.setName(name);
				result.setEmail(email);
				result.setPassword(password);
				result.setGender(gender);

			}
		} catch (SQLException e) {
			System.out.println("errr=" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return result;
	}

	public UserVo get(String email, String password) {
		UserVo result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnetction();

			String sql = "select no,name from user where email=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();// pstmt 내부에 있으므로 sql문장을 넣어줄 필요 없다.

			while (rs.next()) {
				long no = rs.getLong(1);
				String name = rs.getString(2);

				result = new UserVo();
				result.setNo(no);
				result.setName(name);

			}
		} catch (SQLException e) {
			System.out.println("errr=" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return result;
	}

	public boolean insert(UserVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnetction();

			String sql = "insert into user values(null,?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());

			int cnt = pstmt.executeUpdate();
			result = cnt == 1 ? true : false;

		} catch (SQLException e) {
			System.out.println("errr=" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}

	private Connection getConnetction() throws SQLException {

		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.1.37:3307/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		} catch (ClassNotFoundException e) {
			System.out.println("DriverLoading 실패 : " + e);
		}

		return conn;
	}

}
