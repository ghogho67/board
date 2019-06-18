package kr.or.ddit.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.ament.model.AmentVo;
import kr.or.ddit.ament.service.AmentService;
import kr.or.ddit.ament.service.IAmentService;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.boardDetail.model.BoardDetailVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.utill.PartUtill;

/**
 * Servlet implementation class BoardFormController
 */
@WebServlet("/boardForm")
@MultipartConfig(maxFileSize=1024*1024*10, maxRequestSize = 1024*1024*30)
public class BoardFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBoardService boardService;
	private IAmentService amentService;
	private static final Logger logger = LoggerFactory
			.getLogger(BoardFormController.class);

	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		amentService = new AmentService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserVo userVo = (UserVo) session.getAttribute("USER_INFO");
		String userid = userVo.getUserId();
		
		String board_id = request.getParameter("board_id");
		
		logger.debug("board_id : {}", board_id);
		logger.debug("userid : {}", userid);
		
		request.setAttribute("board_id", board_id);
		request.setAttribute("userid", userid);
		request.getRequestDispatcher("/SE2/boardForm.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// detail 테이블에 담을꺼랑 ament 테이블에 담을것들을 추려보자
		// ament = 첨부파일아이디(ament_id), 게시글아이디(detail_id),
		// (ament_path)첨부파일경로, Ament_nm 원본파일 이름

		// detail = detail_id=detail_nextVal userid BOARD_ID DETAIL_TITLE
		// DETAIL_TEXT
		// 최초 생성시 DETAIL_GROUP 자신의 게시판 아이디 detail_id 를 주면 될듯 DETAIL_DT는 sysdate
		// DETAIL_USE는 생성시 Y값 DETAIL_PARENT = null
		// detail
		// insert into boarddetail values(DETAIL_ID.NEXTVAL, 'brown', '',
		// 'board1', sysdate, '테스트용2', '테스트합니다2', 'Y', DETAIL_ID.NEXTVAL);
		// 받아야될것 userid , board_id , detile_title , detile_text
		request.setCharacterEncoding("UTF-8");
		Collection<Part> parts = request.getParts();
		
		String userid = request.getParameter("userid");
		String detail_title = request.getParameter("detail_title");
		String detail_text = request.getParameter("detail_text");
		String board_id = request.getParameter("board_id");
		logger.debug("userid : {}", userid);
		logger.debug("detail_title : {}", detail_title);
		logger.debug("detail_text : {}", detail_text);
		logger.debug("board_id : {}", board_id);
		
		BoardDetailVo detailVo = new BoardDetailVo();
		detailVo.setUserid(userid);
		detailVo.setDetail_title(detail_title);
		detailVo.setDetail_text(detail_text);
		detailVo.setBoard_id(board_id);
		int isnertDetail = boardService.insertDetaileBoard(detailVo);
		
		
//		request.setAttribute("detail_id", detailVo.getDetail_id());
		logger.debug("detail_id:{}",detailVo.getDetail_id());
//		request.setAttribute("board_id", board_id);
//		request.getRequestDispatcher("/boradDetail").forward(request, response);
	
		
		
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
						
						
						AmentVo amentVo = new AmentVo(detailVo.getDetail_id(),path,file);
						logger.debug("amentVo:{}",amentVo);
						int amentInsert = amentService.insertAment(amentVo);
					}
				}
		}
		
		
		
		response.sendRedirect(request.getContextPath()+"/boradDetail?board_id="+board_id+"&detail_id="+detailVo.getDetail_id());
		
				
	}
}
