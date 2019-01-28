package com.zxa.shortcut.controller;

import com.zxa.shortcut.bean.Page;
import com.zxa.shortcut.bean.PageModel;
import com.zxa.shortcut.bean.ResponseResult;
import com.zxa.shortcut.bean.ShortcutKey;
import com.zxa.shortcut.bean.condition.ShortcutKeyCondition;
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
public class ShortcutKeyController {

	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	ShortcutKeyService shortcutKeyService;

	@GetMapping("/skByName/{name}")
	public ResponseResult getShortcutKeyByName(@PathVariable String name){
		logger.info("enter getShortcutKeyByName params[]" + name);

		ShortcutKey shortcutKey = shortcutKeyService.getShortcutKeyByName(name);
		ResponseResult responseResult = ResultUtil.createSuccess(shortcutKey);

		return responseResult;
	}
	@GetMapping("/skById/{id}")
	public ResponseResult getShortcutKeyById(@PathVariable Integer id){
		logger.info("enter getShortcutKeyByName params[]" + id);

		ShortcutKey shortcutKey = shortcutKeyService.getShortcutKeyById(id);
		ResponseResult responseResult = ResultUtil.createSuccess(shortcutKey);

		return responseResult;
	}

	@PutMapping("/sk")
	public ResponseResult createShortcutKey(@RequestBody ShortcutKey shortcutKey){

		logger.info("Enter createShortcutKey params[]" + shortcutKey);

		ShortcutKey shortcutKey1 = shortcutKeyService.createShortcutKey(shortcutKey);
		ResponseResult responseResult = ResultUtil.createSuccess(shortcutKey);
		return responseResult;
	}

	@PostMapping("/sk")
	public ResponseResult updateShortcutKey(@RequestBody ShortcutKey shortcutKey){

		logger.info("Enter updateShortcutKey params[]" + shortcutKey);

		ShortcutKey shortcutKey1 = shortcutKeyService.updateShortcutKey(shortcutKey);
		ResponseResult responseResult = ResultUtil.createSuccess(shortcutKey);
		return responseResult;
	}



	@RequestMapping(value = "/sk",method = RequestMethod.GET)
	public ResponseResult getAllShortcutKeys(Page page){
		logger.info("Enter getAllShortcutKey()  params" + page);

		if(page == null){
			page = new Page();
		}

		PageModel<ShortcutKey> pageModel =  shortcutKeyService.getShortcutKeys(page);

		ResponseResult responseResult = ResultUtil.createSuccess(pageModel);

		return responseResult;


	}

	@RequestMapping(value = "/sk/byCondition",method = RequestMethod.GET)
	public ResponseResult getListByCondition(ShortcutKeyCondition condition){
		logger.info("Enter getListByCondition()  params" + condition);


		PageModel<ShortcutKey> pageModel =  shortcutKeyService.getListByCondition(condition);

		ResponseResult responseResult = ResultUtil.createSuccess(pageModel);

		return responseResult;


	}

	@RequestMapping(name = "/*", method = RequestMethod.OPTIONS)
	public void option(){

	}


}
