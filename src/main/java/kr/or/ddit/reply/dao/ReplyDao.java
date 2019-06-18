package kr.or.ddit.reply.dao;

import java.util.List;

import kr.or.ddit.mybatis.MyBatisUtill;
import kr.or.ddit.reply.model.ReplyVo;

import org.apache.ibatis.session.SqlSession;

public class ReplyDao implements IReplyDao {

	@Override
	public List<ReplyVo> selectReply(String detail_id) {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		
		List<ReplyVo> replyVo = sqlSession.selectList("reply.replyList",detail_id);
		sqlSession.close();
		return replyVo;
	}

	@Override
	public int insertReply(ReplyVo replyVo) {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		int insertReply = sqlSession.insert("reply.insertReply",replyVo);
		sqlSession.commit();
		sqlSession.close();
		
		return insertReply;
	}

	@Override
	public int deleteReply(String reply_id) {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		int deleteReply = sqlSession.update("reply.deleteReply",reply_id);
		sqlSession.commit();
		sqlSession.close();
		return deleteReply;
	}

}
