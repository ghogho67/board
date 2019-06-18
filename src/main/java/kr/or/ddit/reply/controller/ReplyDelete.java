package kr.or.ddit.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class ReplyDelete
 */
@WebServlet("/replyDelete")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IReplyService replyService;
	private static final Logger logger = LoggerFactory
			.getLogger(ReplyDelete.class);
	

	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String reply_id = request.getParameter("reply_id");
		String board_id = request.getParameter("board_id");
		String detail_id = request.getParameter("detail_id");
		logger.debug("reply_id :{}",reply_id);
		replyService.deleteReply(reply_id);
		
		response.sendRedirect(request.getContextPath()+"/boradDetail?board_id="+board_id+"&detail_id="+detail_id);
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
