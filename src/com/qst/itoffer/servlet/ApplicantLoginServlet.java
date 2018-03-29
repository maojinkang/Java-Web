package com.qst.itoffer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.itoffer.dao.ApplicantDAO;
import com.qst.itoffer.info.Applicantinfo;
import com.qst.itoffer.util.CookieEncryptTool;

/**
 * Servlet implementation class ApplicantLoginServlet
 */
@WebServlet("/ApplicantLoginServlet")
public class ApplicantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantLoginServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		String userType = request.getParameter("userType");
		
		ApplicantDAO dao = new ApplicantDAO();
		int applicantID = dao.login(email,password,userType);
		
		if(applicantID !=0 ){
			int id = dao.isExistResume(applicantID);//判断是否有个人信息
			Applicantinfo applicantinfo = new Applicantinfo(applicantID, email, password,userType);
			request.getSession().setAttribute("applicantinfo", applicantinfo);
			rememberMe(rememberMe,email,password,userType,request,response);
			if(id!=0){
				response.sendRedirect("index.jsp");
			}else{
				response.sendRedirect("resumeGuide.jsp");
			}
		}else{
			out.print("<script type='text/javascript'>");
			out.print("alert('用户名或密码错误，请重新输入！');");
			out.print("window.location='login.jsp';");
			out.print("</script>");
		}
	}

	private void rememberMe(String rememberMe, String email, String password, String userType,HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		if("true".equals(rememberMe)){
			Cookie cookie = new Cookie("cookieEmail", CookieEncryptTool.encodeBase64(email));
			cookie.setPath("/");
			cookie.setMaxAge(365*24*3600);
			response.addCookie(cookie);
			cookie = new Cookie("cookiePwd", CookieEncryptTool.encodeBase64(password));
			cookie.setPath("/");
			cookie.setMaxAge(365*24*3600);
			response.addCookie(cookie);
			cookie = new Cookie("cookieType", CookieEncryptTool.encodeBase64(userType));
			cookie.setPath("/");
			cookie.setMaxAge(365*24*3600);
			response.addCookie(cookie);
		}else {
			Cookie[] cookies = request.getCookies();
			if(cookies!=null) {
				for (Cookie cookie : cookies) {
					if("cookieEmail".equals(cookie.getName())||"cookiePwd".equals(cookie.getName())||"cookieType".equals(cookie.getName())) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}
			}
		}
		
	}

}
