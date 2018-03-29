package com.qst.itoffer.info;

public class Majorinfo {
	private int major_id;
	private String name;
	public int getMajor_id() {
		return major_id;
	}
	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Majorinfo(int major_id, String name) {
		super();
		this.major_id = major_id;
		this.name = name;
	}
	public Majorinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
