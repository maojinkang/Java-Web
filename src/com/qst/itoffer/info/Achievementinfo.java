package com.qst.itoffer.info;

public class Achievementinfo {
	private int id;
	private String chinese_A;
	private String math;
	private String english;
	private String java;
	private String c;
	private String xml;
	private int applicant_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChinese_A() {
		return chinese_A;
	}
	public void setChinese_A(String chinese_A) {
		this.chinese_A = chinese_A;
	}
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getJava() {
		return java;
	}
	public void setJava(String java) {
		this.java = java;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public int getApplicant_id() {
		return applicant_id;
	}
	public void setApplicant_id(int applicant_id) {
		this.applicant_id = applicant_id;
	}
	@Override
	public String toString() {
		return "Achievementinfo [id=" + id + ", chinese_A=" + chinese_A + ", math=" + math + ", english=" + english
				+ ", java=" + java + ", c=" + c + ", xml=" + xml + ", applicant_id=" + applicant_id + "]";
	}
	public Achievementinfo(int id, String chinese_A, String math, String english, String java, String c, String xml,
			int applicant_id) {
		super();
		this.id = id;
		this.chinese_A = chinese_A;
		this.math = math;
		this.english = english;
		this.java = java;
		this.c = c;
		this.xml = xml;
		this.applicant_id = applicant_id;
	}
	public Achievementinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
