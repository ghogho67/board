package kr.or.ddit.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.reply.dao.IReplyDao;
import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.model.ReplyVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReplyDaoTest {
	private IReplyDao dao;
	private static final Logger logger = LoggerFactory
			.getLogger(ReplyDaoTest.class);
	
	@Before
	public void setup(){
		dao = new ReplyDao();
		logger.debug("setup");
	}

	@Test
	public void selectReply() {
		/***Given***/
		String detail_id = "23";

		/***When***/
		List<ReplyVo> replyVoList = dao.selectReply(detail_id);
		
		/***Then***/
		assertEquals(0, replyVoList.size());
		
	}
	
	
	@Test
	public void insertReply() {
		/***Given***/
		String detail_id = "23";
		String reply_text = "댓글을 입력합니다.";
		String userid = "brown";
		
		ReplyVo replyVo = new ReplyVo();
		
		replyVo.setUserid(userid);
		replyVo.setDetail_id(detail_id);
		replyVo.setReply_text(reply_text);

		/***When***/
		int insert = dao.insertReply(replyVo);
		
		/***Then***/
		assertEquals(1, insert);
		
	}
	
	@Test
	public void deleteReply() {
		/***Given***/
		String reply_id = "6";
		
		/***When***/
		int delete = dao.deleteReply(reply_id);
		
		/***Then***/
		assertEquals(1, delete);
		
	}

}
