package com.zxa.shortcut.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: ExcelDate
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/12/9 17:22
 */

@Data
public class ExcelData implements Serializable {


	private static final long serialVersionUID = 924949925353998375L;

	private List<String> titles;

	private List<List<Object>> rows;

	private String name;

}
