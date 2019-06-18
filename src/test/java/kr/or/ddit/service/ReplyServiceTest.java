package kr.or.ddit.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;

import org.junit.Before;
import org.junit.Test;

public class ReplyServiceTest {
	private IReplyService replyService;
	@Before
	public void setup(){
		replyService = new ReplyService();
	}

	
	@Test
	public void selectReply() {
		/***Given***/
		String detail_id = "23";

		/***When***/
		List<ReplyVo> replyVoList = replyService.selectReply(detail_id);
		
		/***Then***/
		assertEquals(1, replyVoList.size());
		
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
		int insert = replyService.insertReply(replyVo);
		
		/***Then***/
		assertEquals(1, insert);
		
	}
	
	@Test
	public void deleteReply() {
		/***Given***/
		String reply_id = "2";
		
		/***When***/
		int delete = replyService.deleteReply(reply_id);
		
		/***Then***/
		assertEquals(1, delete);
		
	}

}
