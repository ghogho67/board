package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.boardDetail.model.BoardDetailVo;
import kr.or.ddit.user.model.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class ReplyDetailBoard
 */
@WebServlet("/replyDetailBoard")
public class ReplyDetailBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IBoardService boardService;
	private static final Logger logger = LoggerFactory
			.getLogger(ReplyDetailBoard.class);

	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserVo userVo = (UserVo) session.getAttribute("USER_INFO");
		String userid = userVo.getUserId();
		String board_id = request.getParameter("board_id");
		String detail_id = request.getParameter("detail_id");
		
		
		
		logger.debug("board_id : {}", board_id);
		logger.debug("userid : {}", userid);
		logger.debug("detail_id : {}", detail_id);
		
		request.setAttribute("board_id", board_id);
		request.setAttribute("userid", userid);
		request.setAttribute("detail_id", detail_id);
		request.getRequestDispatcher("/SE2/boardReply.jsp").forward(request,response);
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String board_id = request.getParameter("board_id");
		String detail_id = request.getParameter("detail_id");
		String userid = request.getParameter("userid");
		
		logger.debug("board_id post : {}", board_id);
		logger.debug("userid post : {}", userid);
		logger.debug("detail_id post : {}", detail_id);
		
		Map<String, String> board = new HashMap<String, String>();
		board.put("board_id", board_id);
		board.put("detail_id", detail_id);
		BoardDetailVo detailVo = boardService.selectDetailBoard(board);
		
		String detail_text = request.getParameter("detail_text");
		String detail_title = request.getParameter("detail_title");
	
		logger.debug("detailVo post : {}", detailVo);
		logger.debug("userid post : {}", userid);
		logger.debug("detail_id post : {}", detail_id);
		logger.debug("detail_text post : {}", detail_text);
		logger.debug("detail_title post : {}", detail_title);
		
		BoardDetailVo ReplydetailVo = new BoardDetailVo();
		ReplydetailVo.setUserid(userid);
		ReplydetailVo.setDetail_parent(detail_id);
		ReplydetailVo.setBoard_id(board_id);
		ReplydetailVo.setDetail_title(detail_title);
		ReplydetailVo.setDetail_text(detail_text);
		ReplydetailVo.setDetail_group(detailVo.getDetail_group());
		
		int insertDetailBoard = boardService.insertReplyDetail(ReplydetailVo);
		
		response.sendRedirect(request.getContextPath()+"/boradDetail?board_id="+board_id+"&detail_id="+ReplydetailVo.getDetail_id());
		
		
		
	}

}
