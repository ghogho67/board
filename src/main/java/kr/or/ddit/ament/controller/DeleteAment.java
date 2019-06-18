package kr.or.ddit.ament.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.ament.service.AmentService;
import kr.or.ddit.ament.service.IAmentService;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class DeleteAment
 */
@WebServlet("/deleteAment")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize = 1024*1024*15)
public class DeleteAment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IAmentService amentService; 
    
    private static final Logger logger = LoggerFactory
			.getLogger(DeleteAment.class);
    
	
	@Override
	public void init() throws ServletException {
		amentService = new AmentService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ament_id = request.getParameter("ament_id");
		String detail_id = request.getParameter("detail_id");
		logger.debug("ament_id :{}", ament_id);
		logger.debug("detail_id :{}", detail_id);
		
		
		
		int a = amentService.deleteAment(ament_id);
		if(a == 1){
			response.sendRedirect(request.getContextPath()+"/boardDetailModify?detail_id="+detail_id);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
