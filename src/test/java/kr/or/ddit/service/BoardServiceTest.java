package kr.or.ddit.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.boardDetail.model.BoardDetailVo;
import kr.or.ddit.dao.boardDaoTest;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardServiceTest {

	private IBoardService boardService;
	private static final Logger logger = LoggerFactory
			.getLogger(boardDaoTest.class);
	
	@Before
	public void setup(){
		boardService = new BoardService();
		logger.debug("setup");
	}
	
	
	@Test
	public void getAllBoardList() {
	/***Given***/
	

	/***When***/
		List<BoardVo> boardList = boardService.BoardList();
	/***Then***/
		logger.debug("boardList : {}", boardList);
		assertEquals(1
				, boardList.size());
	}
	
	
	@Test
	public void insetBoardList(){
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_id("test4");
		boardVo.setUserid("brown");
		boardVo.setBoard_nm("boardtest1");
		boardVo.setBoard_use("Y");
		
		/***When***/
		int intertCnt = boardService.insetBoard(boardVo);

		/***Then***/
		assertEquals(1, intertCnt);

	}
	
	@Test
	public void updateBoard(){
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_id("test1");
		boardVo.setBoard_use("N");
		boardVo.setBoard_nm("changeBoard1234");

		/***When***/
		int updateBoard = boardService.updateBoard(boardVo);

		/***Then***/
		assertEquals(1, updateBoard);
		
	}
	
	@Test
	public void updateBoardUse(){
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_id("board3");
		boardVo.setBoard_use("N");

		/***When***/
		int updateBoard = boardService.updateBoardUse(boardVo);

		/***Then***/
		assertEquals(1, updateBoard);
		
	}
	//==========================================   DetailBoard PasingList  ==========================================
	@Test
	public void boardDetsatil(){
		/***Given***/
		int pageInt = 1;
		int pageSize = 10;
		String board_id = "board1";
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("page", pageInt);
		resultMap.put("pageSize", pageInt);
		resultMap.put("board_id", board_id);

		/***When***/
		Map<String, Object> resultMap2 =boardService.detailPagingList(resultMap);

		/***Then***/
			assertEquals(null, resultMap2);

	}
	
	//==========================================   DetailBoard FormInsert  ==========================================
	
	@Test
	public void baordDetailInsert(){
		/***Given***/
		String userid = "brown";
		String board_id = "board3";
		String detail_title = "테스트용123";
		String detail_text = "테스트 내용414141";
		
		BoardDetailVo detailVo = new BoardDetailVo();
		detailVo.setUserid(userid);
		detailVo.setBoard_id(board_id);
		detailVo.setDetail_title(detail_title);
		detailVo.setDetail_text(detail_text);
				
		
		

		/***When***/
			int boardCnt = boardService.insertDetaileBoard(detailVo);

		/***Then***/
			assertEquals(1, boardCnt);

	}
	
	
	@Test
	public void boardDelete(){
		/***Given***/
		String detail_id = "1";

		/***When***/
		
		int delete = boardService.deleteDetailBoard(detail_id);
		

		/***Then***/
		assertEquals(1, delete);
	}
	
	//==========================================  ReplyDetailBoard  ==========================================
	@Test
	public void insertReplyBoard(){
		/***Given***/
		String userid = "brown";
		String detail_parent = "45";
		String board_id = "board3";
		String detail_title = "답글3";
		String detail_text = "답글3내용";
		String detail_group = "3";
		
		BoardDetailVo detailVo = new BoardDetailVo();
		detailVo.setUserid(userid);
		detailVo.setDetail_parent(detail_parent);
		detailVo.setBoard_id(board_id);
		detailVo.setDetail_title(detail_title);
		detailVo.setDetail_text(detail_text);
		detailVo.setDetail_group(detail_group);				
		
		

		/***When***/
			int boardCnt = boardService.insertReplyDetail(detailVo);

		/***Then***/
			assertEquals(1, boardCnt);
	}
	



}
