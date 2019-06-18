package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.boardDetail.model.BoardDetailVo;
import kr.or.ddit.mybatis.MyBatisUtill;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardDao implements IBoardDao {
	private static final Logger logger = LoggerFactory
			.getLogger(BoardDao.class);
	

	@Override
	public List<BoardVo> BoardList() {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.boardList");
		
		sqlSession.close();
		return boardList;
	}


	@Override
	public int insetBoard(BoardVo boardVo) {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		int insertCnt = sqlSession.insert("board.insertBoard", boardVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}


	@Override
	public int updateBoard(BoardVo boardVo) {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		int updateBoard = sqlSession.update("board.updateBoard", boardVo);
		sqlSession.commit();
		sqlSession.close();
		return updateBoard;
	}

	//==========================================   DetailBoard PaginList  ==========================================
	@Override
	public int updateBoardUse(BoardVo boardVo) {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		int updateBoardUse = sqlSession.update("board.updateBoardUse", boardVo);
		sqlSession.commit();
		sqlSession.close();
		return updateBoardUse;
	}


	@Override
	public List<BoardDetailVo> detailPagingList(Map<String, Object> resultMap) {
		SqlSession sqlsession = MyBatisUtill.getSqlSession();
		List<BoardDetailVo> boardList = sqlsession.selectList("board.detailPagingList", resultMap);
		
		sqlsession.close();
		return boardList;
	}

	
	@Override
	public int detailCnt(Map<String, Object> resultMap) {
		SqlSession sqlsession = MyBatisUtill.getSqlSession();
		int detailCnt = sqlsession.selectOne("board.detailCnt",resultMap);
		sqlsession.close();
		return detailCnt;
	}

	//==========================================   DetailBoard form  ==========================================
	@Override
	public int insertDetaileBoard(BoardDetailVo detailVo) {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		int detailInsert = sqlSession.insert("board.insertDetaileBoard",detailVo);
		String detail_id = detailVo.getDetail_id();
		sqlSession.commit();
		sqlSession.close();
		
		return detailInsert;
	}
	
	public BoardDetailVo selectDetailBoard(Map<String, String> board){
		SqlSession sqlSesstion = MyBatisUtill.getSqlSession();
		BoardDetailVo detailVo = sqlSesstion.selectOne("board.selectDetailBoard", board);
		sqlSesstion.close();
		
		return detailVo;
	}

	//==========================================   DetailBoard Modify, delete  ==========================================
	

	@Override
	public int modifyDetailBoard(BoardDetailVo detailVo) {
		SqlSession sqlSesstion = MyBatisUtill.getSqlSession();
		int detailModify = sqlSesstion.update("board.modifyDetailBoard", detailVo);
		sqlSesstion.commit();
		sqlSesstion.close();
		return detailModify;
	}


	@Override
	public int deleteDetailBoard(String detail_id) {
		SqlSession sqlSesstion = MyBatisUtill.getSqlSession();
		int detailDelte = sqlSesstion.update("board.deleteDetailBoard", detail_id);
		sqlSesstion.commit();
		sqlSesstion.close();
		return detailDelte;
	}


	
	
	//==========================================  ReplyDetailBoard  ==========================================
	
	@Override
	public int insertReplyDetail(BoardDetailVo detailVo) {
		SqlSession sqlSesstion = MyBatisUtill.getSqlSession();
		int detailDelte = sqlSesstion.insert("board.insertReplyDetail", detailVo);
		sqlSesstion.commit();
		sqlSesstion.close();
		return detailDelte;
	}
	
	
	
}
