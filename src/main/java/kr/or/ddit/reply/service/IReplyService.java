package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

public interface IReplyService {

	List<ReplyVo> selectReply(String detail_id);

	int insertReply(ReplyVo replyVo);

	int deleteReply(String reply_id);
}
