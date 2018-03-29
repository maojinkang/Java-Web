package com.qst.itoffer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.itoffer.dao.ApplicantDAO;
import com.qst.itoffer.dao.StudentDAO;

/**
 * Servlet implementation class addStudentServlet
 */
@WebServlet("/addStudentServlet")
public class addStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String TB_D = "tb_department";
	private final String TB_M = "tb_major";
	private final String TB_C = "tb_class";
	private int id1;
	private int id2;
	private int id3;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String DEPARTMENT = request.getParameter("DEPARTMENT");
		String MAJOR = request.getParameter("MAJOR");
		String CLASS = request.getParameter("CLASS");
		int n = Integer.valueOf(request.getParameter("n"));
		String n1 = request.getParameter("n1");
		PrintWriter out = response.getWriter();
		ApplicantDAO dao = new ApplicantDAO();
		StudentDAO dao1 = new StudentDAO();
		
		
		for(int i=0;i<n;i++) {
			int nn = Integer.valueOf(n1);
			dao.save(nn+"", "123456", "student");
			n1 = nn+1+"";
			nmb(dao1,DEPARTMENT,MAJOR,CLASS);
			int applicant_id=dao.selectId(nn+"");
			dao1.saveStudent(applicant_id, id1, id2, id3);
			System.out.println(applicant_id+" "+id1+" "+id2+" "+id3);
		}
		out.print("<script type='text/javascript'>");
		out.print("alert('Ìí¼Ó³É¹¦£¡');");
		out.print("window.location='index.jsp';");
		out.print("</script>");
		
	}
	
	private void nmb(StudentDAO dao1,String DEPARTMENT,String MAJOR,String CLASS) {
		if(dao1.isExist(TB_D, DEPARTMENT)) {
			id1 = dao1.selectID(TB_D, "department_id", DEPARTMENT);
		}else {
			dao1.saveD(TB_D, DEPARTMENT);
			id1 = dao1.selectID(TB_D, "department_id", DEPARTMENT);
		}
		
		if(dao1.isExistCM(TB_M, MAJOR, id1, "department_id")){
			id2 = dao1.selectIDCM(TB_M, "major_id", MAJOR, "department_id", id1);
		}else {
			dao1.save(TB_M, MAJOR,"department_id",id1);
			id2 = dao1.selectIDCM(TB_M, "major_id", MAJOR,"department_id", id1);
		}
		
		if(dao1.isExistCM(TB_C, CLASS, id2, "MAJOR_ID")) {
			id3 = dao1.selectIDCM(TB_C, "class_id", CLASS,"MAJOR_ID",id2);
		}else {
			dao1.save(TB_C, CLASS,"major_id",id2);
			id3 = dao1.selectIDCM(TB_C, "class_id", CLASS,"MAJOR_ID",id2);
		}
		
	}

}
