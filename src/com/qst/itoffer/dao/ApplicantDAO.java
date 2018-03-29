package com.qst.itoffer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qst.itoffer.util.DBUtil;

public class ApplicantDAO {

	/**
	 * 验证用户名是否已被注册
	 * 
	 */
	public boolean isExistEmail(String email) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_applicant WHERE applicant_email=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return false;
	}

	/**
	 * 用户注册保存
	 * 
	 */
	public void save(String email, String password,String type) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tb_applicant(applicant_email,applicant_pwd,applicant_type) VALUES(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setString(3, type);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
	}

	/**
	 * 注册用户登录
	 * 
	 */
	public int login(String email, String password,String userType) {
		int applicantID = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT applicant_id FROM tb_applicant WHERE applicant_email=? and applicant_pwd=? and applicant_type=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setString(3, userType);
			rs = pstmt.executeQuery();
			if (rs.next())
				applicantID = rs.getInt("applicant_id");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return applicantID;
	}

	/**
	 * 根据用户名查询id
	 */
	public int selectId(String email) {
		int applicantID = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT applicant_id FROM tb_applicant WHERE applicant_email=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next())
				applicantID = rs.getInt("applicant_id");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return applicantID;
	}
	
	/**
	 * 根据id查询用户名
	 */
	public String selectEmail(int id) {
		String email = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT applicant_email FROM tb_applicant WHERE applicant_id=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				email = rs.getString("applicant_email");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return email;
	}
	/**
	 * 判断是否已有个人信息
	 * 
	 */
	public int isExistResume(int applicantID) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT student_id FROM tb_student WHERE applicant_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applicantID);
			rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return 0;
	}
	/**
	 * 修改密码
	 */
	public int upDatePassword(int id,String password) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "update tb_applicant set applicant_pwd=? where applicant_id=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, password);
			pst.setInt(2, id);
			pst.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pst, con);
		}
		return 0;
	}
	/**
	 * 删除用户
	 * @param id
	 * @param password
	 * @return
	 */
	public void delete(int id) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "DELETE FROM tb_applicant WHERE applicant_id=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pst, con);
		}
	}
}
