package com.qst.itoffer.info;

public class Userinfo {
	private int id;
	private int id1;
	private String name;
	private String sno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSno() {
		return sno;
	}
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public Userinfo(int id, int id1, String name, String sno) {
		super();
		this.id = id;
		this.id1 = id1;
		this.name = name;
		this.sno = sno;
	}
	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
