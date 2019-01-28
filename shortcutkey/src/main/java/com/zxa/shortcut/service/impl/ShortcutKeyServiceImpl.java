package com.zxa.shortcut.service.impl;

import com.zxa.shortcut.bean.Page;
import com.zxa.shortcut.bean.PageModel;
import com.zxa.shortcut.bean.ShortcutKey;
import com.zxa.shortcut.bean.condition.ShortcutKeyCondition;
import com.zxa.shortcut.dao.ShortcutKeyMapper;
import com.zxa.shortcut.service.ShortcutKeyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: ShortcutKeyServiceImpl
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/26 21:56
 */
@Service
public class ShortcutKeyServiceImpl implements ShortcutKeyService {

	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	ShortcutKeyMapper shortcutKeyMapper;

	@Override
	public ShortcutKey getShortcutKeyById(Integer id) {
		return shortcutKeyMapper.selectByPrimaryKey(id);
	}

	@Override
	public ShortcutKey getShortcutKeyByName(String name) {
		return shortcutKeyMapper.getShortcutKeyByName(name);
	}

	@Override
	public ShortcutKey createShortcutKey(ShortcutKey shortcutKey) {
		shortcutKey.setCreateTime(new Date());
		shortcutKey.setUpdateTime(new Date());
		shortcutKeyMapper.insertSelective(shortcutKey);
		ShortcutKey shortcutKey1 = shortcutKeyMapper.selectByPrimaryKey(shortcutKey.getId());

		return shortcutKey;
	}


	@Override
	public ShortcutKey updateShortcutKey(ShortcutKey shortcutKey) {
		shortcutKey.setUpdateTime(new Date());
		shortcutKeyMapper.updateByPrimaryKeySelective(shortcutKey);
		ShortcutKey shortcutKey1 = shortcutKeyMapper.selectByPrimaryKey(shortcutKey.getId());

		return shortcutKey;
	}

	/**
	 * @description //查询所有
	 * @method  getShortcutKeys
	 * @params  [page]
	 * @return java.util.List<com.zxa.shortcut.bean.PageModel>
	 * @date: 2018/11/27 14:34
	 * @author:zhangxin_an
	 */
	@Override
	public PageModel<ShortcutKey> getShortcutKeys(Page page) {
		ShortcutKeyCondition condition = new ShortcutKeyCondition();
		condition.setStatus('1');
		int count = (int)shortcutKeyMapper.getCount(condition);

		page.setTotal(count);
		List<ShortcutKey> shortcutKeyList = shortcutKeyMapper.getAllShorcutKeys(page);
		PageModel<ShortcutKey> pageModel = new PageModel(shortcutKeyList);
		pageModel.setTotal(page.getTotal());
		pageModel.setTotalPage(page.getTotalPage());

		return pageModel;
	}


	@Override
	public PageModel<ShortcutKey> getListByCondition(ShortcutKeyCondition condition) {
		int count = (int)shortcutKeyMapper.getCount(condition);

		condition.setTotal(count);
		List<ShortcutKey> shortcutKeyList = shortcutKeyMapper.getByCondition(condition);
		PageModel<ShortcutKey> pageModel = new PageModel(shortcutKeyList);
		pageModel.setTotal(condition.getTotal());
		pageModel.setTotalPage(condition.getTotalPage());

		return pageModel;
	}
}
