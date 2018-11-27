package com.zxa.shortcut.service.impl;

import com.zxa.shortcut.bean.ShortcutKey;
import com.zxa.shortcut.dao.ShortcutKeyMapper;
import com.zxa.shortcut.service.ShortcutKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName: ShortcutKeyServiceImpl
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/26 21:56
 */
@Service
public class ShortcutKeyServiceImpl implements ShortcutKeyService {

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
}
