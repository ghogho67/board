package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.dao.IReplyDao;
import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.model.ReplyVo;


public class ReplyService implements IReplyService {
	
	private IReplyDao dao;

	public ReplyService() {
		dao = new ReplyDao();
	}

	@Override
	public List<ReplyVo> selectReply(String detail_id) {
		return dao.selectReply(detail_id);
	}

	@Override
	public int insertReply(ReplyVo replyVo) {
		return dao.insertReply(replyVo);
	}

	@Override
	public int deleteReply(String reply_id) {
		return dao.deleteReply(reply_id);
	}

}
