package com.zxa.shortcut.controller;

import com.zxa.shortcut.bean.ResponseResult;
import com.zxa.shortcut.bean.ShortcutKey;
import com.zxa.shortcut.service.ShortcutKeyService;
import com.zxa.shortcut.utils.ResultUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: ShortcutKeyController
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/27 11:07
 */
@RestController
@RequestMapping("/sk")
public class ShortcutKeyController {

	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	ShortcutKeyService shortcutKeyService;

	@GetMapping("/{name}")
	public ResponseResult getShortcutKeyByName(@PathVariable String name){

		ShortcutKey shortcutKey = shortcutKeyService.getShortcutKeyByName(name);
		ResponseResult responseResult = ResultUtil.createSuccess(shortcutKey);

		return responseResult;
	}

	@PutMapping
	public ResponseResult createShortcutKey(@RequestBody ShortcutKey shortcutKey){

		logger.info("Enter createShortcutKey params[]" + shortcutKey);

		ShortcutKey shortcutKey1 = shortcutKeyService.createShortcutKey(shortcutKey);
		ResponseResult responseResult = ResultUtil.createSuccess(shortcutKey);
		return responseResult;
	}


}
