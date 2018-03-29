package com.qst.itoffer.util;

import com.qst.itoffer.dao.StudentDAO;
import com.qst.itoffer.info.Studentinfo;
import com.qst.itoffer.info.tb_Student;

public class StudentinfoUtil {
	private final String TB_D = "tb_department";
	private final String TB_M = "tb_major";
	private final String TB_C = "tb_class";
	public Studentinfo getStudentinfo(int id) {
		StudentDAO dao = new StudentDAO();
		tb_Student tbs = dao.selectStudnetForID(id);
		Studentinfo info = new Studentinfo(tbs.getSTUDENT_ID(), tbs.getAPPLICANT_ID(), tbs.getSTUDENT_NAME(), dao.selectNameForID(TB_D, "department_id", tbs.getDEPARTMENT_ID()), dao.selectNameForID(TB_M, "major_id", tbs.getMAJOR_ID()), dao.selectNameForID(TB_C, "class_id", tbs.getCLASS_ID()),tbs.getSex());
		return info;
	}
}
