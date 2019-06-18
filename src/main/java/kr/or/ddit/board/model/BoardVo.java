package kr.or.ddit.board.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("boardVo")
public class BoardVo {
	
	private String board_id;
	private String userid;
	private String board_nm;
	private String board_use;
	private Date board_dt;
	
	public String getBoard_id() {
		return board_id;
	}
	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBoard_nm() {
		return board_nm;
	}
	public void setBoard_nm(String board_nm) {
		this.board_nm = board_nm;
	}
	public String getBoard_use() {
		return board_use;
	}
	public void setBoard_use(String board_use) {
		this.board_use = board_use;
	}
	public Date getBoard_dt() {
		return board_dt;
	}
	public void setBoard_dt(Date board_dt) {
		this.board_dt = board_dt;
	}
	
	public BoardVo() {
	}
	
	public BoardVo(String board_id, String userid, String board_nm,
			String board_use, Date board_dt) {
		super();
		this.board_id = board_id;
		this.userid = userid;
		this.board_nm = board_nm;
		this.board_use = board_use;
		this.board_dt = board_dt;
	}
	
	public BoardVo(String userid, String board_nm,
			String board_use) {
		super();
		this.userid = userid;
		this.board_nm = board_nm;
		this.board_use = board_use;
	}
	
	@Override
	public String toString() {
		return "BoardVo [board_id=" + board_id + ", userid=" + userid
				+ ", board_nm=" + board_nm + ", board_use=" + board_use
				+ ", board_dt=" + board_dt + "]";
	}
	
	
	
	
	

}
