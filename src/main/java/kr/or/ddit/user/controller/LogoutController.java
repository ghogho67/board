package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그아웃은 세션의 정보를 지워주면된다
		HttpSession session = request.getSession();
		session.invalidate();//session에 저장된 쿠키(정보!!)를 지워준다.
		
		//session.invalidate(); 은 세션을 소멸시키는것이 아니라 정보를 지워주는것일뿐 세션자체가 null이 되지 않는다.
		
		//그리고 상식적으로 로그아웃하면 로그인창이나 메인창그대로 보내준다.	
		request.getRequestDispatcher("/login").forward(request, response);
		
	}


}
