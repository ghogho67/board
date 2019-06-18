package kr.or.ddit.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.boardDetail.model.BoardDetailVo;
import kr.or.ddit.user.dao.UserDao;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class boardDaoTest {
	private IBoardDao dao;
	private static final Logger logger = LoggerFactory
			.getLogger(boardDaoTest.class);
	
	@Before
	public void setup(){
		dao = new BoardDao();
		logger.debug("setup");
	}
	
	
	@Test
	public void getAllBoardList() {
	/***Given***/
	

	/***When***/
		List<BoardVo> boardList = dao.BoardList();
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
		int intertCnt = dao.insetBoard(boardVo);

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
		int updateBoard = dao.updateBoard(boardVo);

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
		int updateBoard = dao.updateBoardUse(boardVo);

		/***Then***/
		assertEquals(1, updateBoard);
		
	}
	
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
			List<BoardDetailVo> boardList = dao.detailPagingList(resultMap);

		/***Then***/
			assertEquals(0, boardList.size());

	}
	
	@Test
	public void boardDetsatilCnt(){
		/***Given***/
		int pageInt = 1;
		int pageSize = 10;
		String board_id = "board1";
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("page", pageInt);
		resultMap.put("pageSize", pageInt);
		resultMap.put("board_id", board_id);

		/***When***/
			int boardCnt = dao.detailCnt(resultMap);

		/***Then***/
			assertEquals(0, boardCnt);

	}
	
	@Test
	public void baordDetailInsert(){
		/***Given***/
		String userid = "brown";
		String board_id = "board1";
		String detail_title = "테스트용123";
		String detail_text = "테스트 내용414141";
		
		BoardDetailVo detailVo = new BoardDetailVo();
		detailVo.setUserid(userid);
		detailVo.setBoard_id(board_id);
		detailVo.setDetail_title(detail_title);
		detailVo.setDetail_text(detail_text);
				
		
		

		/***When***/
			int boardCnt = dao.insertDetaileBoard(detailVo);

		/***Then***/
			assertEquals(1, boardCnt);

	}
	
	@Test
	public void boardDetailSelect(){
		/***Given***/
		Map<String, String> detailBoard = new HashMap<String, String>();
		
		detailBoard.put("board_id", "board1");
		detailBoard.put("detail_id", "2");

		/***When***/
		
		BoardDetailVo detailVo = dao.selectDetailBoard(detailBoard);
		

		/***Then***/
		assertEquals("2", detailVo.getDetail_id());
		assertEquals("board1", detailVo.getBoard_id());
		assertEquals("테스트용123", detailVo.getDetail_title());

	}
	
	@Test
	public void boardModify(){
		/***Given***/
		String detail_title = "수정테스트";
		String detail_text = "수정테스트";
		String detail_id = "23";
		
		BoardDetailVo detailVo = new BoardDetailVo();
		detailVo.setDetail_title(detail_title);
		detailVo.setDetail_id(detail_id);
		detailVo.setDetail_text(detail_text);;
		

		/***When***/
		
		int a = dao.modifyDetailBoard(detailVo);
		

		/***Then***/
		assertEquals(1, a);

	}
	
	@Test
	public void boardDelete(){
		/***Given***/
		String detail_id = "23";

		/***When***/
		
		int delete = dao.deleteDetailBoard(detail_id);
		

		/***Then***/
		assertEquals(1, delete);
	}
	
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
			int boardCnt = dao.insertReplyDetail(detailVo);

		/***Then***/
			assertEquals(1, boardCnt);
	}
	
	

	

}
