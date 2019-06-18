package kr.or.ddit.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.ament.model.AmentVo;
import kr.or.ddit.ament.service.AmentService;
import kr.or.ddit.ament.service.IAmentService;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.boardDetail.model.BoardDetailVo;
import kr.or.ddit.utill.PartUtill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class BoardDetailModify
 */
@WebServlet("/boardDetailModify")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize = 1024*1024*15)
public class BoardDetailModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBoardService boardService;
	private IAmentService amentService;
	private static final Logger logger = LoggerFactory
			.getLogger(BoardDetailModify.class);

	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		amentService = new AmentService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String board_id = request.getParameter("board_id");
		String detail_id = request.getParameter("detail_id");
		Map<String, String> board = new HashMap<String, String>();
		board.put("board_id", board_id);
		board.put("detail_id", detail_id);
		BoardDetailVo detailVo = boardService.selectDetailBoard(board);
		List<AmentVo> amentList = amentService.selectAment(detail_id);
		
		
		request.setAttribute("amentList", amentList);
		request.setAttribute("detailVo", detailVo);
		request.getRequestDispatcher("/SE2/boardModify.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String detail_title = request.getParameter("detail_title");
		String detail_text = request.getParameter("detail_text");
		String board_id = request.getParameter("board_id");
		String detail_id = request.getParameter("detail_id");
		String ament_id = request.getParameter("ament_id");
		
		logger.debug("detail_id : {}", detail_id);
		logger.debug("detail_title : {}", detail_title);
		logger.debug("detail_text : {}", detail_text);
		logger.debug("board_id : {}", board_id);
		logger.debug("ament_id : {}", ament_id);
		
		BoardDetailVo detailVo = new BoardDetailVo();
		
		detailVo.setDetail_title(detail_title);
		detailVo.setDetail_id(detail_id);
		detailVo.setDetail_text(detail_text);
		detailVo.setBoard_id(board_id);
		int modifyDetail = boardService.modifyDetailBoard(detailVo);
		
		Collection<Part> parts = request.getParts();
		int a = parts.size();
		logger.debug("a:{}",a);
		for(Part part : parts){
			if(part.getName().equals("file") && part.getSize() > 0){
				
				String contentDisposition = part.getHeader("content-disposition");
				
				logger.debug("contentDisposition : {}", contentDisposition);
				
				String file = PartUtill.getFileName(contentDisposition);
				logger.debug("fileName : {}", file);
				
				String ext = PartUtill.getExt(file);
				logger.debug("ext : {}", ext);
				
				//년도에 해당하는 폴더가 있는지, 년도안에 월에 해당하는 폴더가있는지 
				Date dt = new Date();
				SimpleDateFormat yyyyMmSdf = new SimpleDateFormat("yyyyMM"); 
				String yyyyMm = yyyyMmSdf.format(dt);
				String yyyy = yyyyMm.substring(0,4);
				String mm= yyyyMm.substring(4);
				
				
				String uploadpath = PartUtill.getUploadPath();
				File uploadFolder = new File(uploadpath);
					if(uploadFolder.exists()){
						//파일 디스크에 쓰기 / UUID.randomUUID 이름값을 중복이 안되게 임의의 값으로 출력한다.
						String path = uploadpath +"\\"+ UUID.randomUUID() + ext;
						part.write(path);  // 경로를 써준다.
						part.delete();
						
						AmentVo amentVo = new AmentVo(detail_id,path,file);
						logger.debug("amentVo:{}",amentVo);
						int updateAment = amentService.insertAment(amentVo);
					}
				}
		}
		
		
		
		
		
		response.sendRedirect(request.getContextPath()+"/boradDetail?board_id="+board_id+"&detail_id="+detail_id);
		
	}

}
