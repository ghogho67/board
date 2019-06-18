package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.encrypt.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * Servlet implementation class LoginController2
 */


/**
* LoginController.java
*
* @author PC21
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC21 최초 생성
*
* </pre>
*/

//web.xml servlet, servlet-mapping --> java annotation
@WebServlet("/login")
//이거 하나로 다된다. ㄷㄷ
public class LoginController extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	private static final long serialVersionUID = 1L;
	private IUserService userService;
	private IBoardService boardService;
	
	
       
	
	@Override
	public void init() throws ServletException {
		userService =  new UserService();
		boardService = new BoardService();
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("USER_INFO") != null){
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			
		}else{
			 RequestDispatcher rd = request.getRequestDispatcher("/login/login.jsp");
			 rd.forward(request, response);
		}
		
		
		 
		
				 
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		logger.debug("parameter remember  : {}" ,request.getParameter("remember"));
//		logger.debug("parameter userId : {}" , request.getParameter("userId"));
//		logger.debug("parameter password : {}" , request.getParameter("password"));
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String encyptPassword = KISA_SHA256.encrypt(password);
		
		UserVo vo = userService.getUser(userId);
		List<BoardVo> bvoList = boardService.BoardList();
		
		
		if(vo != null && 
				encyptPassword.equals(vo.getPass())){
			
			
			int cookieMaxAge = 0;
			if(request.getParameter("remember")!=null){
				cookieMaxAge = 60*60*24*30;
			}
				
				Cookie userIdCookie = new Cookie("userId", userId);
				userIdCookie.setMaxAge(cookieMaxAge); //초단위라서 이렇게 30일 만들었음 setMaxAge 값이 0이면 지워진다.
				
				Cookie rememberCookie = new Cookie("remember", "true");
				rememberCookie.setMaxAge(cookieMaxAge);
				
				response.addCookie(userIdCookie);
				response.addCookie(rememberCookie); 
			
				
				
			HttpSession session = request.getSession();
			session.setAttribute("USER_INFO", vo);
			request.getServletContext().setAttribute("BOARD_INFO", bvoList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);
			
		}else{ 
			
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath()+"/login");
		}
		
		
	}
	
	}

