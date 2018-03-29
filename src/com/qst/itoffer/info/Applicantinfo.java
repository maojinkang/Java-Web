package com.qst.itoffer.info;

public class Applicantinfo {
	private int APPLICANT_ID;
	private String APPLICANT_EMAIL;
	private String APPLICANT_PWD;
	private String APPLICANT_TYPE;
	
	public int getAPPLICANT_ID() {
		return APPLICANT_ID;
	}

	public void setAPPLICANT_ID(int aPPLICANT_ID) {
		APPLICANT_ID = aPPLICANT_ID;
	}

	public String getAPPLICANT_EMAIL() {
		return APPLICANT_EMAIL;
	}

	public void setAPPLICANT_EMAIL(String aPPLICANT_EMAIL) {
		APPLICANT_EMAIL = aPPLICANT_EMAIL;
	}

	public String getAPPLICANT_PWD() {
		return APPLICANT_PWD;
	}

	public void setAPPLICANT_PWD(String aPPLICANT_PWD) {
		APPLICANT_PWD = aPPLICANT_PWD;
	}

	public String getAPPLICANT_TYPE() {
		return APPLICANT_TYPE;
	}

	public void setAPPLICANT_TYPE(String aPPLICANT_TYPE) {
		APPLICANT_TYPE = aPPLICANT_TYPE;
	}
	
	public Applicantinfo(int aPPLICANT_ID, String aPPLICANT_EMAIL, String aPPLICANT_PWD, String aPPLICANT_TYPE) {
		super();
		APPLICANT_ID = aPPLICANT_ID;
		APPLICANT_EMAIL = aPPLICANT_EMAIL;
		APPLICANT_PWD = aPPLICANT_PWD;
		APPLICANT_TYPE = aPPLICANT_TYPE;
	}

	public Applicantinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
