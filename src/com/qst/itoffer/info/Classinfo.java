package com.qst.itoffer.info;

public class Classinfo {
	private int class_id;
	private String name;
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Classinfo(int class_id, String name) {
		super();
		this.class_id = class_id;
		this.name = name;
	}
	public Classinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
