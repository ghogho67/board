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
 * Servlet implementation class ModifyBaordController
 */
@WebServlet("/modify")
public class ModifyBaordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBoardService boardService;
	private static final Logger logger = LoggerFactory
			.getLogger(ModifyBaordController.class);
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVo> boardList = boardService.BoardList();
		request.getServletContext().setAttribute("BOARD_INFO", boardList);
		request.getRequestDispatcher("/board/addBoard.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardVo boardVo = new BoardVo();
		
		String board_Nm = request.getParameter("board_nm");
		String selectBoxVal = request.getParameter("combobox");
		String board_id = request.getParameter("board_id");
		logger.debug("board_NmModifController : {}" , board_Nm);
		logger.debug("comboboxValModyController : {}" , selectBoxVal);
		logger.debug("board_idController : {}" , board_id);
		
		if(board_Nm.equals("")){
			boardVo.setBoard_id(board_id);
			boardVo.setBoard_use(selectBoxVal);
			
			int updateBoard = boardService.updateBoardUse(boardVo);
			
		}else{
			boardVo.setBoard_id(board_id);
			boardVo.setBoard_nm(board_Nm);
			boardVo.setBoard_use(selectBoxVal);
			
			int updateBoard = boardService.updateBoard(boardVo);
		}
		
		response.sendRedirect(request.getContextPath()+"/modify");
		
		
	}

}
