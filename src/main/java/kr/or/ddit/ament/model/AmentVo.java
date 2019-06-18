package kr.or.ddit.ament.model;

import org.apache.ibatis.type.Alias;


@Alias("amentVo")
public class AmentVo {
	private String ament_id; //첨부파일아이디
	private String detail_id; //게시글아이디
	private String ament_path; //첨부파일경로
	private String ament_nm;  //원본파일이름
	
	
	public String getAment_id() {
		return ament_id;
	}
	public void setAment_id(String ament_id) {
		this.ament_id = ament_id;
	}
	public String getDetail_id() {
		return detail_id;
	}
	public void setDetail_id(String detail_id) {
		this.detail_id = detail_id;
	}
	public String getAment_path() {
		return ament_path;
	}
	public void setAment_path(String ament_path) {
		this.ament_path = ament_path;
	}
	public String getAment_nm() {
		return ament_nm;
	}
	public void setAment_nm(String ament_nm) {
		this.ament_nm = ament_nm;
	}
	
	public AmentVo() {

	}
	
	public AmentVo(String detail_id, String ament_path,
			String ament_nm) {
		super();
		this.detail_id = detail_id;
		this.ament_path = ament_path;
		this.ament_nm = ament_nm;
	}
	
	
	
	public AmentVo(String ament_id, String detail_id, String ament_path,
			String ament_nm) {
		super();
		this.ament_id = ament_id;
		this.detail_id = detail_id;
		this.ament_path = ament_path;
		this.ament_nm = ament_nm;
	}
	
	
	@Override
	public String toString() {
		return "AmentVo [ament_id=" + ament_id + ", detail_id=" + detail_id
				+ ", ament_path=" + ament_path + ", ament_nm=" + ament_nm + "]";
	}
	
	
	
	
	
	

}
