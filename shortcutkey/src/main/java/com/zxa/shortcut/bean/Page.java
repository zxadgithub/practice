package com.zxa.shortcut.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName: PageModel
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/27 14:12
 */
@Data
@ToString
public class Page<T> {

	private String order = "create_time";
	private int pageNum = 1 ;
	private int pageSize = 10;
	private int total;
	private int totalPage;
	private int offset;
	private List<T> data;

	public int getOffset() {
		return pageNum  == 0 ? 0 : (pageNum - 1) * pageSize;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum > 0 ? pageNum : 1;
	}



	public void setTotalPage() {
		this.totalPage = total  % getPageSize() == 0 ? total  / getPageSize() : total  / getPageSize() + 1 ;

	}
	public void setTotal(int total) {
		this.total = total;
		setTotalPage();
		pageNum = pageNum > getTotalPage() ? getTotalPage() : pageNum ;
	}
}


