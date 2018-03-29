package com.qst.itoffer.info;

public class tb_Student {
	private int STUDENT_ID;
	private int APPLICANT_ID;
	private String STUDENT_NAME;
	private int DEPARTMENT_ID;
	private int MAJOR_ID;
	private int CLASS_ID;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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
	public int getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}
	public void setDEPARTMENT_ID(int dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
	public int getMAJOR_ID() {
		return MAJOR_ID;
	}
	public void setMAJOR_ID(int mAJOR_ID) {
		MAJOR_ID = mAJOR_ID;
	}
	public int getCLASS_ID() {
		return CLASS_ID;
	}
	public void setCLASS_ID(int cLASS_ID) {
		CLASS_ID = cLASS_ID;
	}
	public tb_Student(int sTUDENT_ID, int aPPLICANT_ID, String sTUDENT_NAME, int dEPARTMENT_ID, int mAJOR_ID,
			int cLASS_ID) {
		super();
		STUDENT_ID = sTUDENT_ID;
		APPLICANT_ID = aPPLICANT_ID;
		STUDENT_NAME = sTUDENT_NAME;
		DEPARTMENT_ID = dEPARTMENT_ID;
		MAJOR_ID = mAJOR_ID;
		CLASS_ID = cLASS_ID;
	}
	public tb_Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
