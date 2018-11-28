package com.zxa.shortcut.bean;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: PageModel
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/27 14:12
 */
@Data
public class PageModel<T> {

	private int total;
	private int totalPage;
	private List<T> data;

	public PageModel(List data) {
		this.data = data;
	}
	public PageModel() {
	}
}
