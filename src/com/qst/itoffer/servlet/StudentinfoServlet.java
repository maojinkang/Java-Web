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
import com.qst.itoffer.info.Studentinfo;
import com.qst.itoffer.util.StudentinfoUtil;

/**
 * Servlet implementation class StudentinfoServlet
 */
@WebServlet("/StudentinfoServlet")
public class StudentinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentinfoServlet() {
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
		
		String type = request.getParameter("type");
		int id = Integer.valueOf(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		if(type.equals("select")) {
			Studentinfo info = (new StudentinfoUtil()).getStudentinfo(id);
			request.setAttribute("studentinfo", info);
			request.getRequestDispatcher("Sinformation.jsp").forward(request, response);
		}
		if(type.equals("update")) {
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			StudentDAO dao = new StudentDAO();
			dao.upDate(dao.selectID(id), name, sex);
			out.print("<script type='text/javascript'>");
			out.print("alert('ÐÞ¸Ä³É¹¦£¡');");
			out.print("window.location='index.jsp';");
			out.print("</script>");
		}
		if(type.equals("delete")) {
			int s_id = Integer.valueOf(request.getParameter("id1"));
			int c_id = Integer.valueOf(request.getParameter("class_id"));
			StudentDAO dao = new StudentDAO();
			ApplicantDAO dao1 = new ApplicantDAO();
			dao.delete(s_id);
			dao1.delete(id);
			response.sendRedirect("SelectStudentServlet?class_id="+c_id);
		}
	}

}
