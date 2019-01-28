package com.zxa.shortcut.dao;

import com.zxa.shortcut.bean.Page;
import com.zxa.shortcut.bean.ShortcutKey;
import com.zxa.shortcut.bean.condition.ShortcutKeyCondition;

import java.util.List;

public interface ShortcutKeyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShortcutKey record);

    int insertSelective(ShortcutKey record);

    ShortcutKey selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShortcutKey record);

    int updateByPrimaryKey(ShortcutKey record);

    ShortcutKey getShortcutKeyByName(String name);

    List<ShortcutKey> getAllShorcutKeys(Page page);

    long getCount(ShortcutKeyCondition shortcutKeyCondition);

    List<ShortcutKey> getByCondition(ShortcutKeyCondition shortcutKeyCondition);

}