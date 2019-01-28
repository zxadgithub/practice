package com.zxa.shortcut.service;

		import com.zxa.shortcut.bean.Page;
		import com.zxa.shortcut.bean.PageModel;
		import com.zxa.shortcut.bean.ShortcutKey;
		import com.zxa.shortcut.bean.condition.ShortcutKeyCondition;

/**
 * @ClassName: ShortcutKeyService
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/26 21:55
 */
public interface ShortcutKeyService {

	ShortcutKey getShortcutKeyById(Integer id);

	ShortcutKey getShortcutKeyByName(String name);

	ShortcutKey createShortcutKey(ShortcutKey shortcutKey);

	PageModel<ShortcutKey> getShortcutKeys(Page page);

	ShortcutKey updateShortcutKey(ShortcutKey shortcutKey);

	PageModel<ShortcutKey> getListByCondition(ShortcutKeyCondition condition);
}
