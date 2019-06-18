package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.model.UserVo;

/**
 * Servlet implementation class AddBoardController
 */
@WebServlet("/addBoard")
public class AddBoardController extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(AddBoardController.class);
	private static final long serialVersionUID = 1L;
      private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<BoardVo> boardList = boardService.BoardList();
		request.getServletContext().setAttribute("BOARD_INFO", boardList);
		request.getRequestDispatcher("/board/addBoard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardVo boardVo = new BoardVo();
		HttpSession session = request.getSession();
		UserVo userVo = (UserVo) session.getAttribute("USER_INFO");
		String userid = userVo.getUserId();
		
		String board_Nm = request.getParameter("board_nm");
		String selectBoxVal = request.getParameter("combobox");
		logger.debug("board_NmController : {}" , board_Nm);
		logger.debug("selectBoxValController : {}" , selectBoxVal);
		logger.debug("useridController : {}" , userid);
		
		boardVo.setUserid(userid);
		boardVo.setBoard_nm(board_Nm);
		boardVo.setBoard_use(selectBoxVal);
		
		int insertCnt = boardService.insetBoard(boardVo);
		response.sendRedirect(request.getContextPath()+"/addBoard");		
																																																																																																								
		
	}

}
