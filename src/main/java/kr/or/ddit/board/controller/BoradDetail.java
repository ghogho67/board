package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.ament.model.AmentVo;
import kr.or.ddit.ament.service.AmentService;
import kr.or.ddit.ament.service.IAmentService;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.boardDetail.model.BoardDetailVo;
import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class BoradDetail
 */
@WebServlet("/boradDetail")
public class BoradDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBoardService boardService;
	private IReplyService replyService;
	private IAmentService amentService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(BoradDetail.class);

	@Override
	public void init() throws ServletException {
		boardService = new BoardService();	
		replyService = new ReplyService();
		amentService = new AmentService();
	}
	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String board_id = request.getParameter("board_id");
		String detail_id = request.getParameter("detail_id");
		Map<String, String> board = new HashMap<String, String>();
		board.put("board_id", board_id);
		board.put("detail_id", detail_id);
		
		BoardDetailVo detailVo = boardService.selectDetailBoard(board);
		List<ReplyVo> replyVoList = replyService.selectReply(detail_id);
		List<AmentVo> amentList = amentService.selectAment(detail_id);
		
		request.setAttribute("board_id", board_id);
		request.setAttribute("detail_id", detail_id);
		request.setAttribute("detailVo", detailVo);
		request.setAttribute("replyVoList", replyVoList);
		request.setAttribute("amentList", amentList);
		logger.debug("replyVoList:{}",replyVoList);
		logger.debug("amentList:{}",amentList);
		
		request.getRequestDispatcher("/board/detailBoard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
	
		
	}

}
