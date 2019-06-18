package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.boardDetail.model.BoardDetailVo;

public class BoardService implements IBoardService{

	private IBoardDao dao;

	public BoardService() {
		dao = new BoardDao();
	}

	@Override
	public List<BoardVo> BoardList() {
		return dao.BoardList();
	}

	@Override
	public int insetBoard(BoardVo boardVo) {
		return dao.insetBoard(boardVo);
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		return dao.updateBoard(boardVo);
	}


	@Override
	public int updateBoardUse(BoardVo boardVo) {
		return dao.updateBoardUse(boardVo);
	}

	//==========================================   DetailBoard PagingList  ==========================================
	@Override
	public Map<String, Object> detailPagingList(Map<String, Object> resultMap) {
		int pageSize = (int) resultMap.get("pageSize");
		
		Map<String, Object> result1Map = new HashMap<String, Object>();
		result1Map.put("detailList", dao.detailPagingList(resultMap));
		
		int detailCnt = dao.detailCnt(resultMap);
		
		int paginationSize = (int)Math.ceil((double)detailCnt/pageSize);
		result1Map.put("paginationSize", paginationSize);
		
		
		return result1Map;
	}



	
	
	//==========================================   DetailBoard form  ==========================================
	
	@Override
	public int insertDetaileBoard(BoardDetailVo detailVo) {
		return dao.insertDetaileBoard(detailVo);
	}


	@Override
	public BoardDetailVo selectDetailBoard(Map<String, String> board) {
		return dao.selectDetailBoard(board);
	}

	//==========================================   DetailBoard Modify, delete  ==========================================
	@Override
	public int modifyDetailBoard(BoardDetailVo detailVo) {
		return dao.modifyDetailBoard(detailVo);
	}

	@Override
	public int deleteDetailBoard(String detail_id) {
		return dao.deleteDetailBoard(detail_id);
	}
	
	//==========================================  ReplyDetailBoard  ==========================================

	@Override
	public int insertReplyDetail(BoardDetailVo detailVo) {
		return dao.insertReplyDetail(detailVo);
	}
	
	
	
	
}
