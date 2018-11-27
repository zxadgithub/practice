package com.zxa.shortcut.dao;

import com.zxa.shortcut.bean.ShortcutKey;

public interface ShortcutKeyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShortcutKey record);

    int insertSelective(ShortcutKey record);

    ShortcutKey selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShortcutKey record);

    int updateByPrimaryKey(ShortcutKey record);

    ShortcutKey getShortcutKeyByName(String name);
}