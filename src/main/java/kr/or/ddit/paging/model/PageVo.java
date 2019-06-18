package kr.or.ddit.paging.model;

import org.apache.ibatis.type.Alias;


@Alias("pageVo")
public class PageVo {
	private int page; 	  // 페이지번호
	private int pageSize; // 페이지당 건수
	
	
	
	public PageVo() {
	
	}
	public PageVo(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "PageVo [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
	

}
