package com.qst.itoffer.info;

public class Departmentinfo {
	private int department_id;
	private String name;
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Departmentinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departmentinfo(int department_id, String name) {
		super();
		this.department_id = department_id;
		this.name = name;
	}
	
	
}
