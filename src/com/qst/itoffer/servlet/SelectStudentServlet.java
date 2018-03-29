package com.qst.itoffer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qst.itoffer.dao.StudentDAO;
import com.qst.itoffer.info.Applicantinfo;
import com.qst.itoffer.info.Departmentinfo;
import com.qst.itoffer.info.Userinfo;

/**
 * Servlet implementation class SelectStudentServlet
 */
@WebServlet("/SelectStudentServlet")
public class SelectStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectStudentServlet() {
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
		
		int class_id = Integer.valueOf(request.getParameter("class_id"));
		if(class_id<=0) {
			StudentDAO dao = new StudentDAO();
			List<Departmentinfo> list = dao.selectAll();
			request.setAttribute("list_D", list);
			request.getRequestDispatcher("selectallStuendt.jsp?page=one").forward(request, response);
		}else {
			StudentDAO dao = new StudentDAO();
			List<Userinfo> list = dao.selectU(class_id);
			request.setAttribute("list_U", list);
			HttpSession session = request.getSession();
			if(((Applicantinfo)session.getAttribute("applicantinfo")).getAPPLICANT_TYPE().equals("teacher")) {
				request.getRequestDispatcher("allStuendt.jsp?page=one&&class_id="+class_id).forward(request, response);	
			}else {
				request.getRequestDispatcher("allStuendt.jsp?page=two&&class_id="+class_id).forward(request, response);
			}
		}
	}

}
