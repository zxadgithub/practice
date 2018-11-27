package com.zxa.shortcut.utils;

import com.zxa.shortcut.bean.ResponseResult;

/**
 * @ClassName: ResultUtil
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/27 11:10
 */
public class ResultUtil<T> {

	public enum Status{
		OK(1), FAIL(0);
		int status;
		Status(int status){
			this.status = status;
		}
	}

	public enum ErrorCode{
		BAD_REQUEST("A0001"),BUSINESS_EXCEPTION("A0002");
		String values;

		ErrorCode(String values){
			this.values = values;
		}


	}

	public static <T> ResponseResult<T> createSuccess(T data){
		return new ResponseResult(null, null, data, Status.OK.status);
	}

	public static <T> ResponseResult<T> createFail(String errcode, String errotMessage, T data){
		return new ResponseResult<>(errcode, errotMessage, data, Status.FAIL.status);
	}

	public static <T> ResponseResult<T> createFail(String errotMessage, T data){
		return new ResponseResult<>(ErrorCode.BUSINESS_EXCEPTION.values, errotMessage, data, Status.FAIL.status);
	}

	public static <T> ResponseResult<T> createFail(T data){
		return new ResponseResult<>(ErrorCode.BUSINESS_EXCEPTION.values, "系统错误", data, Status.FAIL.status);
	}

	public static <T> ResponseResult<T> createFail(){
		return new ResponseResult<>(ErrorCode.BUSINESS_EXCEPTION.values, "系统错误", null, Status.FAIL.status);
	}


}
