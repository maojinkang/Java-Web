package com.qst.itoffer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qst.itoffer.info.Achievementinfo;
import com.qst.itoffer.util.DBUtil;

public class AchievementDAO {
	public void save(Achievementinfo info) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "INSERT INTO tb_achievement(applicant_id,Chinese_a,Math,English,java,c,xml) VALUES(?,?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, info.getApplicant_id());
			pst.setString(2, info.getChinese_A());
			pst.setString(3, info.getMath());
			pst.setString(4, info.getEnglish());
			pst.setString(5, info.getJava());
			pst.setString(6, info.getC());
			pst.setString(7, info.getXml());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pst, con);
		}
	}
	
	public Achievementinfo select(int id) {
		Connection con = DBUtil.getConnection();
		Achievementinfo aa = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TB_achievement WHERE APPLICANT_ID=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				aa = new Achievementinfo();
				aa.setId(rs.getInt(1));
				aa.setApplicant_id(id);
				aa.setChinese_A(rs.getString(3));
				aa.setMath(rs.getString(4));
				aa.setEnglish(rs.getString(5));
				aa.setJava(rs.getString(6));
				aa.setC(rs.getString(7));
				aa.setXml(rs.getString(8));
				return aa;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(rs, pst, con);
		}
		return aa;
	}
	
	public int upDate(Achievementinfo info,int id) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "update TB_achievement set Chinese_a =?,Math=?,English=?,java=?,c=?,xml=? where applicant_id=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, info.getChinese_A());
			pst.setString(2, info.getMath());
			pst.setString(3, info.getEnglish());
			pst.setString(4, info.getJava());
			pst.setString(5, info.getC());
			pst.setString(6, info.getXml());
			pst.setInt(7, id);
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
}
