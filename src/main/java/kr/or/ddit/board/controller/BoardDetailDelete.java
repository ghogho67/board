package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class BoardDetailDelete
 */
@WebServlet("/boardDetailDelete")
public class BoardDetailDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBoardService boardService;
	private static final Logger logger = LoggerFactory
			.getLogger(BoardDetailModify.class);

	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String board_id = request.getParameter("board_id");
		String detail_id = request.getParameter("detail_id");
		int deleteDetail = boardService.deleteDetailBoard(detail_id);
		
		response.sendRedirect(request.getContextPath()+"/detailPaging?board_id="+board_id+"&detail_id="+detail_id);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
