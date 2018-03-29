package com.qst.itoffer.servlet;

import com.qst.itoffer.dao.AchievementDAO;
import com.qst.itoffer.info.Achievementinfo;

public class test {
	public static void main(String[] args) {
		AchievementDAO dao = new AchievementDAO();
		Achievementinfo info = dao.select(61);
		System.out.println(info.toString());
	}
}
