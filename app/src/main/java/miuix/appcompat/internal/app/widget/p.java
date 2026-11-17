package miuix.appcompat.internal.app.widget;

import android.content.Context;
import com.android.mmt.R;

/* loaded from: classes.dex */
public final class p extends ScrollingTabContainerView {
    public p(Context context) {
        super(context);
        l(-2);
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int f() {
        return R.attr.actionBarTabTextSecondaryExpandStyle;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int g() {
        return R.layout.miuix_appcompat_action_bar_tabbar_secondary;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int h() {
        return -2;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int i() {
        return R.layout.miuix_appcompat_action_bar_tab_secondary;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int j() {
        return getContext().getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_action_bar_tab_secondary_margin);
    }
}
