package kr.or.ddit.boardDetail.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;


@Alias("detailVo")
public class BoardDetailVo {
	private String detail_id;          	  // 게시글 번호                
	private String userid;             	 // 게시글 쓴 아이디              
	private String detail_parent;      	//부모 게시판 답글달때 필요           
	private String board_id;            	   //게시판 종류                
	private Date detail_dt;            //게시글 쓴 일시                   
	private String detail_title;           //게시글 제목                   
	private String detail_text;        // 게시글 내용                      
	private String detail_use;           //게시글 삭제여부                   
	private String detail_group;        //그룹맺어주는      
	private int rn;	//게시물 번호
	private int lv;	//lever 제목 띄어쓰기 해주기 
	
	
	
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public String getDetail_id() {
		return detail_id;
	}
	public void setDetail_id(String detail_id) {
		this.detail_id = detail_id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDetail_parent() {
		return detail_parent;
	}
	public void setDetail_parent(String detail_parent) {
		this.detail_parent = detail_parent;
	}
	public String getBoard_id() {
		return board_id;
	}
	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}
	public Date getDetail_dt() {
		return detail_dt;
	}
	public void setDetail_dt(Date detail_dt) {
		this.detail_dt = detail_dt;
	}
	public String getDetail_title() {
		return detail_title;
	}
	public void setDetail_title(String detail_title) {
		this.detail_title = detail_title;
	}
	public String getDetail_text() {
		return detail_text;
	}
	public void setDetail_text(String detail_text) {
		this.detail_text = detail_text;
	}
	public String getDetail_use() {
		return detail_use;
	}
	public void setDetail_use(String detail_use) {
		this.detail_use = detail_use;
	}
	public String getDetail_group() {
		return detail_group;
	}
	public void setDetail_group(String detail_group) {
		this.detail_group = detail_group;
	}
	
	public BoardDetailVo(String detail_id, String userid, String detail_parent,
			String board_id, Date detail_dt, String detail_title,
			String detail_text, String detail_use, String detail_group) {
		super();
		this.detail_id = detail_id;
		this.userid = userid;
		this.detail_parent = detail_parent;
		this.board_id = board_id;
		this.detail_dt = detail_dt;
		this.detail_title = detail_title;
		this.detail_text = detail_text;
		this.detail_use = detail_use;
		this.detail_group = detail_group;
	}
	
	
	public BoardDetailVo( String userid, 
			String board_id, String detail_title,
			String detail_text, String detail_group) {
		super();
		this.userid = userid;
		this.board_id = board_id;
		this.detail_title = detail_title;
		this.detail_text = detail_text;
		this.detail_group = detail_group;
	}
	
	public BoardDetailVo() {
		
	}
	@Override
	public String toString() {
		return "BoardDitailVo [detail_id=" + detail_id + ", userid=" + userid
				+ ", detail_parent=" + detail_parent + ", board_id=" + board_id
				+ ", detail_dt=" + detail_dt + ", detail_title=" + detail_title
				+ ", detail_text=" + detail_text + ", detail_use=" + detail_use
				+ ", detail_group=" + detail_group + "]";
	}
	
	
	
	                                                                  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
