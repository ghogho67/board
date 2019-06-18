package kr.or.ddit.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.user.model.UserVo;

/**
 * Servlet implementation class ReplyInsert
 */
@WebServlet("/replyInsert")
public class ReplyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IReplyService replyService;
	private static final Logger logger = LoggerFactory
			.getLogger(ReplyInsert.class);
	

	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		UserVo userVo = (UserVo) session.getAttribute("USER_INFO");
		String userid = userVo.getUserId();
		
		String detail_id = request.getParameter("detail_id");
		String reply_text = request.getParameter("reply_text");
		
		String board_id = request.getParameter("board_id");
		logger.debug("reply_text : {}",reply_text);
		
		ReplyVo replyVo = new ReplyVo();
		
		replyVo.setUserid(userid);
		replyVo.setDetail_id(detail_id);
		replyVo.setReply_text(reply_text);
		
		int insertReply = replyService.insertReply(replyVo);
		
		response.sendRedirect(request.getContextPath()+"/boradDetail?board_id="+board_id+"&detail_id="+detail_id);
		
		
		
		
		
		
		
	}

}
