package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.boardDetail.model.BoardDetailVo;
import kr.or.ddit.paging.model.PageVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class UserPagingList
 */
@WebServlet("/detailPaging")
public class DetailPagingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBoardService boardService;
	private static final Logger logger = LoggerFactory
			.getLogger(DetailPagingList.class);
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		String board_id = request.getParameter("board_id");
//		logger.debug("board_id : {}", board_id);
		
		
		int pageInt = page == null ? 1 : Integer.parseInt(page);
		int pageSizeInt = pageSize == null ? 10 : Integer.parseInt(pageSize);
		
//		logger.debug("pageInt : {}", pageInt);
//		logger.debug("pageSizeInt : {}", pageSizeInt);
		
		PageVo pageVo = new PageVo(pageInt,pageSizeInt);
		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("page", pageInt);
		resultMap.put("pageSize", pageSizeInt);
		resultMap.put("board_id", board_id);
		
//		logger.debug("resultMap.put : {}", resultMap.get("pageSize"));
		//pageVo를 이용한 사용자 페이징 리스트 조회
		Map<String,Object> result2Map =  boardService.detailPagingList(resultMap);
		int paginationSize = (Integer)result2Map.get("paginationSize");
		List<BoardDetailVo> detailList = (List<BoardDetailVo>) result2Map.get("detailList");
		
		//request scope에 사용자 리스를 공유할 수 있도록 속성 설정
		request.setAttribute("detailList", detailList);
//		logger.debug("detailList : {}" , detailList );
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		request.setAttribute("board_nm", request.getParameter("board_nm"));
		request.setAttribute("board_id", board_id);
		
		List<BoardVo> bvoList = boardService.BoardList();
		request.getServletContext().setAttribute("BOARD_INFO", bvoList);
		
		
	    
	    request.getRequestDispatcher("/board/detileListBoard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
