package kr.or.ddit.reply.dao;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

public interface IReplyDao {
	
	List<ReplyVo> selectReply(String detail_id);
	
	int insertReply(ReplyVo replyVo);
	
	int deleteReply(String reply_id);

}
