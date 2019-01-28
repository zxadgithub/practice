package com.zxa.shortcut.bean.condition;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zxa.shortcut.bean.Page;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName: ShortcutKeyCondition
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2019/1/28 16:17
 */
@Data
public class ShortcutKeyCondition extends Page {
	private Integer id;

	private String name;

	private String operation;

	private String description;

	private String secondCategory;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;


	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateTime;

	private String firstCategory;

	private Character status;
}
