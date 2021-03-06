package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.ArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class BaseMenuWrapper {
    final Context mContext;
    private Map<SupportMenuItem, MenuItem> mMenuItems;
    private Map<SupportSubMenu, SubMenu> mSubMenus;

    BaseMenuWrapper(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: 0000 */
    public final MenuItem getMenuItemWrapper(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.mMenuItems == null) {
            this.mMenuItems = new ArrayMap();
        }
        MenuItem wrappedItem = (MenuItem) this.mMenuItems.get(menuItem);
        if (wrappedItem == null) {
            wrappedItem = new MenuItemWrapperICS(this.mContext, supportMenuItem);
            this.mMenuItems.put(supportMenuItem, wrappedItem);
        }
        return wrappedItem;
    }

    /* access modifiers changed from: 0000 */
    public final SubMenu getSubMenuWrapper(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.mSubMenus == null) {
            this.mSubMenus = new ArrayMap();
        }
        SubMenu wrappedMenu = (SubMenu) this.mSubMenus.get(supportSubMenu);
        if (wrappedMenu == null) {
            wrappedMenu = new SubMenuWrapperICS(this.mContext, supportSubMenu);
            this.mSubMenus.put(supportSubMenu, wrappedMenu);
        }
        return wrappedMenu;
    }

    /* access modifiers changed from: 0000 */
    public final void internalClear() {
        Map<SupportMenuItem, MenuItem> map = this.mMenuItems;
        if (map != null) {
            map.clear();
        }
        Map<SupportSubMenu, SubMenu> map2 = this.mSubMenus;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    public final void internalRemoveGroup(int groupId) {
        Map<SupportMenuItem, MenuItem> map = this.mMenuItems;
        if (map != null) {
            Iterator<SupportMenuItem> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                if (groupId == ((MenuItem) iterator.next()).getGroupId()) {
                    iterator.remove();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void internalRemoveItem(int id) {
        Map<SupportMenuItem, MenuItem> map = this.mMenuItems;
        if (map != null) {
            Iterator<SupportMenuItem> iterator = map.keySet().iterator();
            while (true) {
                if (iterator.hasNext()) {
                    if (id == ((MenuItem) iterator.next()).getItemId()) {
                        iterator.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
