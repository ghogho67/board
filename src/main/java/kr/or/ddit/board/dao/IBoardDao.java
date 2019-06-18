package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.boardDetail.model.BoardDetailVo;

public interface IBoardDao {
	List<BoardVo> BoardList();

	int insetBoard(BoardVo boardVo);

	int updateBoard(BoardVo boardVo);
	
	int updateBoardUse(BoardVo boardVo);
	
	
	
	//---------DetailBoard PagingList---------------
	List<BoardDetailVo> detailPagingList(Map<String, Object> resultMap);

	int detailCnt(Map<String, Object> resultMap);
	
	//---------DetailBoard Form---------------
	int insertDetaileBoard(BoardDetailVo detailVo);
	
	BoardDetailVo selectDetailBoard(Map<String, String> board);
	
	//==========================================   DetailBoard Modify, delete  ==========================================
	
	int modifyDetailBoard(BoardDetailVo detailVo);
	
	int deleteDetailBoard(String detail_id);
	
	//==========================================  ReplyDetailBoard  ==========================================
	
	int insertReplyDetail(BoardDetailVo detailVo);
	
}
