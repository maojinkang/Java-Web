package com.qst.itoffer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.qst.itoffer.info.Classinfo;
import com.qst.itoffer.info.Departmentinfo;
import com.qst.itoffer.info.Majorinfo;
import com.qst.itoffer.info.Userinfo;
import com.qst.itoffer.info.tb_Student;
import com.qst.itoffer.util.DBUtil;

public class StudentDAO {
	/**
	 * 存储学生个人信息
	 */
	public void saveStudent(int applicant_id, int department_id,int major_id,int class_id) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tb_student(applicant_id,department_id,major_id,class_id) VALUES(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applicant_id);
			pstmt.setInt(2, department_id);
			pstmt.setInt(3, major_id);
			pstmt.setInt(4, class_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
	}
	
	/**
	 * 根据applicant_id查询student
	 */
	public tb_Student selectStudnetForID(int applicant_id) {
		Connection con = DBUtil.getConnection();
		tb_Student tbs = new tb_Student();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TB_STUDENT WHERE APPLICANT_ID=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, applicant_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				tbs.setSTUDENT_ID(rs.getInt("student_id"));
				tbs.setAPPLICANT_ID(rs.getInt("applicant_id"));
				tbs.setSTUDENT_NAME(rs.getString("student_name"));
				tbs.setDEPARTMENT_ID(rs.getInt("department_id"));
				tbs.setMAJOR_ID(rs.getInt("major_id"));
				tbs.setCLASS_ID(rs.getInt("class_id"));
				tbs.setSex(rs.getString("sex"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(rs, pst, con);
		}
		return tbs;
	}
	
	/**
	 * 填写姓名与性别
	 */
	public int upDate(int id,String name,String sex) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "update tb_student set student_name=?,sex=? where student_id=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, sex);
			pst.setInt(3, id);
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
	 * 判断tb表是否存在name
	 */
	public boolean isExistCM(String tb,String name,int id,String idname) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+tb+" WHERE name=? and "+idname+"=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
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
	
	
	public boolean isExist(String tb,String name) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+tb+" WHERE name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
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
	 * 根据name查询id
	 */
	public int selectID(String tb,String id_name,String name) {
		int id = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+tb+" WHERE name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next())
				id = rs.getInt(id_name);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return id;
	}
	/**
	 * 根据name查询id 专业与班级表
	 */
	public int selectIDCM(String tb,String id_name,String name,String idname,int id1) {
		int id = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+tb+" WHERE name=? and "+idname+"=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, id1);
			rs = pstmt.executeQuery();
			if (rs.next())
				id = rs.getInt(id_name);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return id;
	}
	/**
	 * 
	 * 根据用户表的id获得信息表的id
	 */
	public int selectID(int applicant_id) {
		int id = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT student_id FROM tb_student WHERE applicant_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applicant_id);
			rs = pstmt.executeQuery();
			if (rs.next())
				id = rs.getInt("student_id");
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return id;
	}
	/**
	 * 根据id查询name
	 * @param tb
	 * @param id_name
	 * @param id
	 * @return
	 */
	public String selectNameForID(String tb,String id_name,int id) {
		String name = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+tb+" WHERE "+id_name+"=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				name = rs.getString("name");
			return name;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return name;
	}
	
	/**
	 * 存储tb_class与tb_major
	 */
	public void save(String tb,String name,String idname,int id) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO "+tb+"(name,"+idname+") VALUES(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
	}
	
	/**
	 * 存储系别表
	 */
	public void saveD(String tb,String name) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO "+tb+"(name) VALUES(?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
	}
	/**
	 * 查询所有系别
	 * @return
	 */
	public List<Departmentinfo> selectAll() {
		String name = null;
		int id = 0;
		List<Departmentinfo> list = new ArrayList<Departmentinfo>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_department";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				id = rs.getInt("department_id");
				name = rs.getString("name");
				list.add(new Departmentinfo(id, name));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return null;
	}
	
	/**
	 * 查询所有专业
	 * @param department_id
	 * @return
	 */
	public List<Majorinfo> selectM(int department_id) {
		String name = null;
		int id = 0;
		List<Majorinfo> list = new ArrayList<Majorinfo>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_major where department_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, department_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				id = rs.getInt("major_id");
				name = rs.getString("name");
				list.add(new Majorinfo(id, name));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return null;
	}
	
	/**
	 * 查询所有班级
	 * @param major_id
	 * @return
	 */
	public List<Classinfo> selectC(int major_id) {
		String name = null;
		int id = 0;
		List<Classinfo> list = new ArrayList<Classinfo>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_class where major_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, major_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				id = rs.getInt("class_id");
				name = rs.getString("name");
				list.add(new Classinfo(id, name));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return null;
	}
	
	/**
	 * 查询所有用户
	 * @param class_id
	 * @return
	 */
	public List<Userinfo> selectU(int class_id) {
		int id;
		int id1;
		String name = null;
		String nso = null;
		List<Userinfo> list = new ArrayList<Userinfo>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_student where class_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, class_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				name = rs.getString("student_name");
				id = rs.getInt("applicant_id");
				id1 = rs.getInt("student_id");
				ApplicantDAO dao = new ApplicantDAO();
				nso = dao.selectEmail(id);
				list.add(new Userinfo(id,id1,name, nso));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return null;
	}
	/**
	 * 删除学生信息
	 * @param id
	 */
	public void delete(int id) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "DELETE FROM tb_student WHERE student_id=?";
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
