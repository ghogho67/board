package kr.or.ddit.reply.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("replyVo")
public class ReplyVo {
	private String reply_id;
	private String userid;
	private String detail_id;
	private String reply_text;
	private Date reply_dt;
	private String reply_use;
	private int rn;
	
	
	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public String getReply_id() {
		return reply_id;
	}

	public void setReply_id(String reply_id) {
		this.reply_id = reply_id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(String detail_id) {
		this.detail_id = detail_id;
	}

	public String getReply_text() {
		return reply_text;
	}

	public void setReply_text(String reply_text) {
		this.reply_text = reply_text;
	}

	public Date getReply_dt() {
		return reply_dt;
	}

	public void setReply_dt(Date reply_dt) {
		this.reply_dt = reply_dt;
	}

	public String getReply_use() {
		return reply_use;
	}

	public void setReply_use(String reply_use) {
		this.reply_use = reply_use;
	}

	public ReplyVo() {
	
	}


	public ReplyVo(String reply_id, String userid, String detail_id,
			String reply_text, Date reply_dt, String reply_use) {
		super();
		this.reply_id = reply_id;
		this.userid = userid;
		this.detail_id = detail_id;
		this.reply_text = reply_text;
		this.reply_dt = reply_dt;
		this.reply_use = reply_use;
	}


	@Override
	public String toString() {
		return "ReplyVo [reply_id=" + reply_id + ", userid=" + userid
				+ ", detail_id=" + detail_id + ", reply_text=" + reply_text
				+ ", reply_dt=" + reply_dt + ", reply_use=" + reply_use + "]";
	}
	

}
