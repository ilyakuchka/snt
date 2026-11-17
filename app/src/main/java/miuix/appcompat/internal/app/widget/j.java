package miuix.appcompat.internal.app.widget;

import android.R;
import android.content.Context;
import t3.C0386a;

/* loaded from: classes.dex */
public final class j extends ScrollingTabContainerView {
    public j(Context context) {
        super(context);
        l(C0386a.b(getContext()).f());
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int f() {
        return R.attr.actionBarTabTextStyle;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int g() {
        return com.android.mmt.R.layout.miuix_appcompat_action_bar_tabbar;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int h() {
        return C0386a.b(getContext()).f();
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int i() {
        return com.android.mmt.R.layout.miuix_appcompat_action_bar_tab;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int j() {
        return 0;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView, android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        super.onLayout(z4, i2, i4, i5, i6);
        int measuredHeight = getMeasuredHeight();
        int measuredHeight2 = this.f6906n.getMeasuredHeight();
        int i7 = (measuredHeight - measuredHeight2) / 2;
        this.f6906n.layout(i2, i7, this.f6906n.getMeasuredWidth(), measuredHeight2 + i7);
    }
}
