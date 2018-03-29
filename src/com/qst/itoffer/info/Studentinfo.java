package com.qst.itoffer.info;

public class Studentinfo {
	  private int STUDENT_ID;
	  private int APPLICANT_ID;
	  private String STUDENT_NAME;
	  private String STUDENT_DEPARTMENT;
	  private String STUDENT_MAJOR;
	  private String STUDENT_CLASS;
	  private String sex;
	public int getSTUDENT_ID() {
		return STUDENT_ID;
	}
	public void setSTUDENT_ID(int sTUDENT_ID) {
		STUDENT_ID = sTUDENT_ID;
	}
	public int getAPPLICANT_ID() {
		return APPLICANT_ID;
	}
	public void setAPPLICANT_ID(int aPPLICANT_ID) {
		APPLICANT_ID = aPPLICANT_ID;
	}
	public String getSTUDENT_NAME() {
		return STUDENT_NAME;
	}
	public void setSTUDENT_NAME(String sTUDENT_NAME) {
		STUDENT_NAME = sTUDENT_NAME;
	}
	public String getSTUDENT_DEPARTMENT() {
		return STUDENT_DEPARTMENT;
	}
	public void setSTUDENT_DEPARTMENT(String sTUDENT_DEPARTMENT) {
		STUDENT_DEPARTMENT = sTUDENT_DEPARTMENT;
	}
	public String getSTUDENT_MAJOR() {
		return STUDENT_MAJOR;
	}
	public void setSTUDENT_MAJOR(String sTUDENT_MAJOR) {
		STUDENT_MAJOR = sTUDENT_MAJOR;
	}
	public String getSTUDENT_CLASS() {
		return STUDENT_CLASS;
	}
	public void setSTUDENT_CLASS(String sTUDENT_CLASS) {
		STUDENT_CLASS = sTUDENT_CLASS;
	}
	public Studentinfo(int sTUDENT_ID, int aPPLICANT_ID, String sTUDENT_NAME, String sTUDENT_DEPARTMENT,
			String sTUDENT_MAJOR, String sTUDENT_CLASS, String sex) {
		super();
		STUDENT_ID = sTUDENT_ID;
		APPLICANT_ID = aPPLICANT_ID;
		STUDENT_NAME = sTUDENT_NAME;
		STUDENT_DEPARTMENT = sTUDENT_DEPARTMENT;
		STUDENT_MAJOR = sTUDENT_MAJOR;
		STUDENT_CLASS = sTUDENT_CLASS;
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Studentinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Studentinfo [STUDENT_ID=" + STUDENT_ID + ", APPLICANT_ID=" + APPLICANT_ID + ", STUDENT_NAME="
				+ STUDENT_NAME + ", STUDENT_DEPARTMENT=" + STUDENT_DEPARTMENT + ", STUDENT_MAJOR=" + STUDENT_MAJOR
				+ ", STUDENT_CLASS=" + STUDENT_CLASS + "]";
	}
	  
	  
}
