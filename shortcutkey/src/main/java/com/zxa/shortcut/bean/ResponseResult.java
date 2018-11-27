package com.zxa.shortcut.bean;

import lombok.Data;

/**
 * @ClassName: ResultBody
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/27 11:08
 */
@Data
public class ResponseResult<T> {
	private String errorCode;
	private String errorMessage;
	private T data;
	private int status;

	public ResponseResult() {
	}

	public ResponseResult(String errorCode, String errorMessage, T data, int status) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.data = data;
		this.status = status;
	}
}
