package com.zxa.shortcut.controller;

import com.zxa.shortcut.bean.ShortcutKey;
import com.zxa.shortcut.service.ShortcutKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/26 21:29
 */
@RestController
public class TestController {

	@Autowired
	ShortcutKeyService shortcutKeyService;

	@GetMapping("/api/test")
	public ShortcutKey test(){
		return shortcutKeyService.getShortcutKeyById(1);
	}

}
